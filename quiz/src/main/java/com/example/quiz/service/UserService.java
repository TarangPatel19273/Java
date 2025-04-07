package com.example.quiz.service;

import com.example.quiz.dao.UserDao;
import com.example.quiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    //password encode here
    public User saveUser(User user) {
    	    user.setPassword(passwordEncoder.encode(user.getPassword()));
    	    return userDao.saveUser(user);
    }

    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userDao.existsByEmail(email);
    }
    
    public boolean existsByUsername(String username) {
        return userDao.findByUsername(username).isPresent();
    }
    
//    public boolean verifyPassword(String rawPassword, String encodedPassword) {
//        return passwordEncoder.matches(rawPassword, encodedPassword);
//    }

}