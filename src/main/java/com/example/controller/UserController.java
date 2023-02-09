package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") String id){
        System.out.println(id);
        return ResponseEntity.ok(new User());
    }

    @GetMapping(value = "/getAllUser",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        System.out.println(user);
        return ResponseEntity.ok(new User());
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id){
        userService.deleteUser(Integer.parseInt(id));
        return ResponseEntity.ok(new User());
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Boolean> validateLogin(@RequestBody Map<String,String> loginData){
        return ResponseEntity.ok(userService.validateLogin(loginData));
    }

}
