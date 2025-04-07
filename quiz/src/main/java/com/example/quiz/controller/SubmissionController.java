package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.quiz.DTO.AnswerRequest;
//import com.example.quiz.model.Submission;
import com.example.quiz.service.SubmissionService;
import com.example.quiz.service.UserService;
import com.example.quiz.model.User;


@RestController
@RequestMapping("/api/quiz")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;
    
    
    @PostMapping("/submit/{id}") // user id
    public ResponseEntity<String> submitQuiz(@RequestBody AnswerRequest request, @PathVariable Long id) {
        Long userId = id;
             
        submissionService.submitQuiz(userId, request);
        return ResponseEntity.ok("Quiz submitted successfully!");
        
     
    }

  

}
