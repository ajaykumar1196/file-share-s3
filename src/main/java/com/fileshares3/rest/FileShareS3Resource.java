package com.fileshares3.rest;


import com.fileshares3.service.FileShareS3Service;
import com.fileshares3.serviceImpl.FileShareS3ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileShareS3Resource {

    private FileShareS3Service fileShareS3Service;

    public FileShareS3Resource(FileShareS3Service fileShareS3Service) {
        this.fileShareS3Service = fileShareS3Service;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.fileShareS3Service.uploadFile(file);
    }
}
