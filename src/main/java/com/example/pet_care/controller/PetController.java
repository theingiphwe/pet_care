package com.example.pet_care.controller;

import com.example.pet_care.dto.PetDto;
import com.example.pet_care.dto.PetRequest;
import com.example.pet_care.entity.*;
import com.example.pet_care.enumTypes.*;
import com.example.pet_care.repo.FilePathRepo;
import com.example.pet_care.service.FileImageService;
import com.example.pet_care.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public ResponseEntity<Pet> createPet(
            @RequestParam String name,
            @RequestParam int age,@RequestParam String breed,
            @RequestParam Gender gender,@RequestParam String description,
            @RequestParam String color,@RequestParam Size size,
            @RequestParam int specieId,@RequestParam int ageTypeId,
            @RequestParam MultipartFile file
    ) throws IOException {
//        if(gender.equals("MALE")){
//            gender.setGender(Gender.MALE);
//        }
//        else {
//            petRequest.setGender(Gender.FEMALE);
//        }
        PetRequest petRequest = new PetRequest();
        petRequest.setName(name);
        petRequest.setAge(age);
        petRequest.setBreed(breed);
        petRequest.setGender(gender);
        petRequest.setDescription(description);
        petRequest.setColor(color);
        petRequest.setSize(size);
        petRequest.setAgeTypeId(ageTypeId);
        petRequest.setSpeciesId(specieId);

        Pet pet =petService.register(petRequest,file);
        return  new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> findById(@PathVariable int id){
        Pet pet = petService.findById(id);
        PetDto petDto = PetDto.of(pet);
        return new ResponseEntity<>(petDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PetDto>> findAll(){
        List<Pet> pets = petService.findAllUser();
        List<PetDto> petDtoList = new ArrayList<>();
        for(Pet pet: pets){
            PetDto petDto = PetDto.of(pet);
            petDtoList.add(petDto);
        }
        return new ResponseEntity<>(petDtoList,HttpStatus.OK);
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
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
