package com.fileshares3.serviceImpl;

import com.amazonaws.services.s3.AmazonS3;
import com.fileshares3.service.FileShareS3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@PropertySource("classpath:application.properties")
public class FileShareS3ServiceImpl implements FileShareS3Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileShareS3ServiceImpl.class);

    private AmazonS3 s3client;

    @Value("${aws.bucketName}")
    private String bucketName;

    public FileShareS3ServiceImpl(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        System.out.println(this.s3client);
        return null;
    }
}
