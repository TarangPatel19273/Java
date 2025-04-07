package com.example.quiz.DTO;

public class QuizResponse {
    private Long questionId;
    private String userAnswer;
    
    // Default constructor
    public QuizResponse() {
    }
    
    // Constructor with parameters
    public QuizResponse(Long questionId, String userAnswer) {
        this.questionId = questionId;
        this.userAnswer = userAnswer;
    }
    
    // Getters and Setters
    public Long getQuestionId() {
        return questionId;
    }
    
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
    public String getUserAnswer() {
        return userAnswer;
    }
    
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
} 