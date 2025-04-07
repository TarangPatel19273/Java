package com.example.quiz.DTO;

import java.util.Map;

public class AnswerRequest {
    private Long quizId;
    private Map<Long, String> answers; // Key: Question ID, Value: Answer

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Map<Long, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, String> answers) {
        this.answers = answers;
    }
}
