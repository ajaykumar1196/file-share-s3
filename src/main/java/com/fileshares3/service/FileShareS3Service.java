package com.fileshares3.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileShareS3Service {
    String uploadFile(MultipartFile file);
}
