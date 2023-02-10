package com.mmcafe.upload.controller;

import com.mmcafe.upload.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class UploadFileController {

    @Autowired
    private UploadFileService service;

    @PostMapping("/upload-file")
    public ResponseEntity<?> gravarImagem(@RequestParam MultipartFile file) throws IOException {

        return ResponseEntity.ok(service.inserirImagem(file));
    }
}
