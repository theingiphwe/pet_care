package com.example.pet_care.controller;

import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.entity.FilePath;
import com.example.pet_care.entity.Pet;
import com.example.pet_care.repo.FilePathRepo;
import com.example.pet_care.service.FileImageService;
import com.example.pet_care.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private FilePathRepo filePathRepo;
    @Autowired
    private FileImageService fileImageService;

    @PostMapping
    public ResponseEntity<PetRequest> createUser(@RequestBody PetRequest petRequest){
        petService.register(petRequest);
        return  new ResponseEntity<>(petRequest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findById(@PathVariable int id){
        Pet pet = petService.findById(id);
        return new ResponseEntity<>(pet,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> findAll(){
        List<Pet> pets = petService.findAllUser();
        return new ResponseEntity<>(pets,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody PetRequest petRequest){
        petService.updateById(id,petRequest);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        petService.deleteById(id);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @PutMapping("/cele/{id}")
    public ResponseEntity<String> isCelebrity(@PathVariable int id,@RequestBody PetRequest petRequest){
        petService.celebrity(id,petRequest);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @GetMapping("/images/{filePathId}")
    public ResponseEntity<byte[]> getImage(@PathVariable int filePathId){
        FilePath filePath = filePathRepo.findById(filePathId)
                .orElseThrow(()-> new IllegalArgumentException());

        try {
            byte[] image = fileImageService.getImageData(filePath.getFilePath());
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).build();
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
