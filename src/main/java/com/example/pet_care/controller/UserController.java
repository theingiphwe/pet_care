package com.example.pet_care.controller;

import com.example.pet_care.entity.Adoption;
import com.example.pet_care.entity.User;
import com.example.pet_care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.create(user);
        return  new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        User user = userService.findById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id,@RequestBody User user){
        userService.updateById(id,user);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        userService.deleteById(id);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<User> loginUser(@RequestParam String userEmail,@RequestParam String userPassword){
        User user =userService.loginUser(userEmail,userPassword);
        return ResponseEntity.ok(user);
    }
}
