package com.mmcafe.upload.service.impl;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.google.gson.Gson;
import com.mmcafe.upload.kafka.producer.UploadFileProducer;
import com.mmcafe.upload.service.UploadFileService;
import com.mmcafe.upload.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class UploadFileServiceImpl implements UploadFileService {


    @Autowired
    private UploadFileProducer producer;

    @Override
    public String inserirImagem(MultipartFile file) throws IOException {

        FileVO vo = new FileVO();
        vo.setNome(file.getOriginalFilename());
        vo.setTipo(file.getContentType());
        vo.setUrl(sendAws(file));

        producer.send(new Gson().toJson(vo));
        return "Imagem Inserida com Sucesso";
    }

    private String sendAws(MultipartFile file) throws IOException {

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dlfufj2bg",
                       "api_key", "376784167159389",
                       "api_secret", "C4A-w4gsdHWwmWAvL83dqmxqwi8"
        ));

        Map uploadResult = cloudinary.uploader().upload(convert(file), ObjectUtils.emptyMap());

        return uploadResult.get("url").toString();

    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
