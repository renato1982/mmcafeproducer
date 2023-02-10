package com.mmcafe.upload.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFileService {

    String inserirImagem(MultipartFile file) throws IOException;
}
