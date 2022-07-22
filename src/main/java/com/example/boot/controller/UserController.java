package com.example.boot.controller;

import com.example.boot.entity.User;
import com.example.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private  UserService userService;


    @GetMapping("/hello-world")
     public String hello(){
        return "hlelo";
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Iterable<User>> getAllUser(){
        return new ResponseEntity<Iterable<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        System.out.println(user);
        User user1=userService.saveUser(user);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    @GetMapping("/getUserById")//"{id}"
    public ResponseEntity<Optional<User>> getUser(@RequestParam("id") int id){ //@PathVarible("id")
           return new ResponseEntity<Optional<User>>( userService.getUserById(id),HttpStatus.OK);
    }

    @PutMapping("/userUpdate")
    public User updateUser(@RequestBody User user){
     return   userService.updateUser(user);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
}
