package com.example.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.quiz.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
