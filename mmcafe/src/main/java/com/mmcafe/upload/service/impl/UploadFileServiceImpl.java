package com.mmcafe.upload.service.impl;

import com.google.gson.Gson;
import com.mmcafe.upload.kafka.producer.UploadFileProducer;
import com.mmcafe.upload.service.UploadFileService;
import com.mmcafe.upload.vo.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    private UploadFileProducer producer;

    @Override
    public String inserirImagem(MultipartFile file) {

        FileVO vo = new FileVO();
        vo.setNome(file.getOriginalFilename());
        vo.setTipo(file.getContentType());
        vo.setUrl("");
        producer.send(new Gson().toJson(vo));
        return "Imagem Inserida com Sucesso";
    }
}
