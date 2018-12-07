package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicePersistence implements UserService {

    @Autowired
    UserRepository userRepository;



    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }



    @Override
    public User getUser(String cc) {
        User u = userRepository.findOne(cc);
        return u;
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public String getUserPermission(String cc) {
        User u = userRepository.findOne(cc);
        return u.getPermission();
    }


}
