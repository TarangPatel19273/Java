package com.example.quiz.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.quiz.model.User;
import com.example.quiz.service.UserService;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists!");
        }

        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already registered!");
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");  // Correct format
        } else if (user.getRole().equalsIgnoreCase("ADMIN")) {
            user.setRole("ROLE_ADMIN");
        }


        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody User user) {
//        Optional<User> foundUser = userService.findByUsername(user.getUsername());
//        if (foundUser.isPresent() && userService.verifyPassword(user.getPassword(), foundUser.get().getPassword())) {
//            return ResponseEntity.ok("Login successful! Welcome, " + foundUser.get().getUsername());
//        } else {
//            return ResponseEntity.status(401).body("Invalid credentials!");
//        }
//    }

}
