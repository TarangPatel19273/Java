package com.example.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.service.QuestionService;
import com.example.quiz.service.QuizService;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;
    
    @Autowired

    public QuestionRepository questionRepository; 

    
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsByQuizId(@PathVariable Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
    
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}") //question id
    public Optional<Question> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

//    @PostMapping
//    public Question createQuestion(@RequestBody Question question) {
//        return questionService.saveQuestion(question);
//    }

    @PutMapping("update/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        question.setId(id);
        return questionService.saveQuestion(question);
    }

    @DeleteMapping("delete/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
    
    @PostMapping("/add/{quizId}")
    public Question addQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        if (!quizService.existsById(quizId)) {
            throw new RuntimeException("Quiz not found with ID: " + quizId);
        }
        return questionService.addQuestion(quizId, question);
    }
}