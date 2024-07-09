package com.example.SoapApiProject.service;

import com.example.SoapApiProject.entity.Users;
import com.example.SoapApiProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(Users user){
        userRepository.save(user);
    }

    public Users readUser(int userId){
        Optional<Users> u = userRepository.findById(userId);
        return u.get();
    }

    public Users updateUser(Users user){
        Optional<Users> u1 = userRepository.findById(user.getUserId());
        Users u2 = u1.get();
        u2.setUserId(user.getUserId());
        u2.setName(user.getName());
        u2.setSalary(user.getSalary());
        return u2;
    }

    public void deleteUser(int userId){
        userRepository.deleteById(userId);
    }
}