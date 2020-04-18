package com.fileshares3.serviceImpl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fileshares3.service.FileShareS3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
    public String uploadFile(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        try {
            File file = null;
            if (fileName != null) {
                file = new File(fileName);
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(multipartFile.getBytes());
                fos.close();
            }
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, new Date().getTime()+ "_" +fileName, file);
            this.s3client.putObject(putObjectRequest);
            if (file != null) {
                file.delete();
            }
        } catch (IOException | AmazonServiceException ex) {
            LOGGER.error("error [" + ex.getMessage() + "] occurred while uploading [" + fileName + "] ");
        }
        return fileName + " successfully uploaded!";
    }
}
