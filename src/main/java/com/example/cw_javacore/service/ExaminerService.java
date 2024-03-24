package com.example.cw_javacore.service;

import com.example.cw_javacore.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions (int amount);
}
