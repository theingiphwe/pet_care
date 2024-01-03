package com.example.pet_care.service;

import com.example.pet_care.entity.FilePath;
import com.example.pet_care.repo.FilePathRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilePathService {
    @Autowired
    private FilePathRepo filePathRepo;

    public void saveFile(FilePath filePath){
        filePathRepo.save(filePath);
    }

}
