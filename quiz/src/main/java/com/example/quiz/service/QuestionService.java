package com.example.quiz.service;

import com.example.quiz.dao.QuestionDao;
import com.example.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    public Optional<Question> getQuestionById(Long id) {
        return questionDao.getQuestionById(id);
    }

    public Question saveQuestion(Question question) {
        return questionDao.saveQuestion(question);
    }

    public void deleteQuestion(Long id) {
        questionDao.deleteQuestion(id);
    }
    
    public Question addQuestion(Long quizId, Question question) {
        return questionDao.addQuestion(quizId, question);
    }
}
