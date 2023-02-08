package com.mmcafe.upload.controller;

import com.mmcafe.upload.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class UploadFileController {

    @Autowired
    private UploadFileService service;

    @PostMapping("/upload-file")
    public ResponseEntity<?> gravarImagem(@RequestParam("file") MultipartFile file){

        return ResponseEntity.ok(service.inserirImagem(file));
    }
}
