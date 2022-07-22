package com.example.boot.service;


import com.example.boot.entity.User;
import com.example.boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private StudentRepository studentRepository;


    public User saveUser(User user){
       return studentRepository.save(user);
    }
}
