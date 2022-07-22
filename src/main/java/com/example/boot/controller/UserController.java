package com.example.boot.controller;

import com.example.boot.entity.User;
import com.example.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private  UserService userService;


    @GetMapping("/hello-world")
     public String hello(){
        return "hlelo";
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        System.out.println(user);
        User user1=userService.saveUser(user);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }
}
