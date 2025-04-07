package com.example.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.example.quiz.DTO.AnswerRequest;
import com.example.quiz.model.*;
import com.example.quiz.model.Submission;
import com.example.quiz.repository.*;


@Service
public class SubmissionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

    public Submission submitQuiz(Long userId, AnswerRequest request) {
        int score = 0;
        Quiz quiz = quizRepository.findById(request.getQuizId()).orElseThrow(() -> new RuntimeException("Quiz not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        for (Map.Entry<Long, String> entry : request.getAnswers().entrySet()) {
            Question question = questionRepository.findById(entry.getKey()).orElseThrow(() -> new RuntimeException("Question not found"));
            if (question.getRightAnswer().equalsIgnoreCase(entry.getValue())) {
                score++;
            }
        }

        Submission submission = new Submission();
        submission.setUser(user);
        submission.setQuiz(quiz);
        submission.setScore(score);
        return submissionRepository.save(submission);
    }
}
