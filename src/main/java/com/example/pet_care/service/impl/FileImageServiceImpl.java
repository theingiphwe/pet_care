package com.example.pet_care.service.impl;

import com.example.pet_care.entity.FilePath;
import com.example.pet_care.service.FileImageService;
import com.example.pet_care.service.FilePathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileImageServiceImpl implements FileImageService {

    @Value("${pet.file.path}")
    private String fileDirectory;

    @Autowired
    private FilePathService filePathService;
    @Override
    public void saveImage(int id, MultipartFile multipartFile)throws IOException {
        String uploadDir = StringUtils.cleanPath(fileDirectory);
        String tempDir = String.valueOf(id);
        Path uploadPath = Paths.get(uploadDir+"/"+tempDir);
        String originalFilename = multipartFile.getOriginalFilename();
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        InputStream inputStream = multipartFile.getInputStream();
        Path filePath = uploadPath.resolve(originalFilename);

        Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        FilePath filePathEntity = new FilePath();
        filePathEntity.setFilePath(tempDir+"/"+originalFilename);

        filePathService.saveFile(filePathEntity);

    }
}
