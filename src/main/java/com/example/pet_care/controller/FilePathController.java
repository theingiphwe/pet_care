package com.example.pet_care.controller;

import com.example.pet_care.service.FileImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/file")
public class FilePathController {

    private FileImageService fileImageService;

    @PostMapping("/saveImage")
    public void saveImage(@RequestParam int id, @RequestParam MultipartFile file){
        try {
            fileImageService.saveImage(id,file);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }


}
