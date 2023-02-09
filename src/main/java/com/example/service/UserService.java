package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User user){
       return userRepository.save(user);
    }
    public List<User> getAllUser(){
        return (List<User>) userRepository.findAll();
    }
    public void deleteUser(Integer id){
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public boolean validateLogin(Map<String ,String> loginData){
            if(userRepository.findByUserNameAndPassword(loginData.get("username"),loginData.get("password")).size() > 0){
                return true;
            }
        return false;
    }

}
