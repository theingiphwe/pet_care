package com.example.pet_care.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileImageService{

   void saveImage(int id, MultipartFile multipartFile)throws IOException;

   byte[] getImageData(String filePath) throws IOException;
}
