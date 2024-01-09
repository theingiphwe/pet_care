package com.example.pet_care.service.impl;

import com.example.pet_care.entity.FilePath;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.repo.PetRepo;
import com.example.pet_care.service.FileImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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
    private  FilePathService filePathService;
    @Autowired
    private  PetRepo petRepo;
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
        Pet petInfo= petRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Pet not Found"));

        Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        FilePath filePathEntity = new FilePath();
        filePathEntity.setFilePath(tempDir+"/"+originalFilename);
        filePathEntity.setPet(petInfo);

        filePathService.saveFile(filePathEntity);

    }

    @Override
    public byte[] getImageData(String filePath) throws IOException {
        String downloadDir = StringUtils.cleanPath(fileDirectory);
        String downloadTmpDir = downloadDir+filePath;
        Path path = Paths.get(downloadTmpDir);
        return Files.readAllBytes(path);
    }

}
