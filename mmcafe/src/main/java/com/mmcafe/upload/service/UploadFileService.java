package com.mmcafe.upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

    String inserirImagem(MultipartFile file);
}
