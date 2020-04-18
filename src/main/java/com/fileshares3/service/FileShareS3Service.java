package com.fileshares3.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileShareS3Service {
    String uploadFile(MultipartFile file);
}
