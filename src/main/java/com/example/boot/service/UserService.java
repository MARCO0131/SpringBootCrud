package com.example.boot.service;


import com.example.boot.entity.User;
import com.example.boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private StudentRepository studentRepository;


    public User saveUser(User user){
       return studentRepository.save(user);
    }

    public Iterable<User> getAllUsers(){
       return studentRepository.findAll();
    }

    public Optional<User> getUserById(int id){
        return studentRepository.findById(id);
    }
    public void deleteUser(int id){
       studentRepository.deleteById(id);
    }

    public User updateUser(User user){
        Optional<User> user1 =studentRepository.findById(user.getId());
        User us = new User();
        if(user1.isPresent()) {
            if(user.getAge()!=null)
            user1.get().setAge(user.getAge());
            if(user.getEmail()!=null)
            user1.get().setEmail(user.getEmail());
            if(user.getName()!=null)
            user1.get().setName(user.getName());
            if(user.getPassword()!=null)
            user1.get().setPassword(user.getPassword());
             us = studentRepository.save(user1.get());
        }
            return us;
    }
}
