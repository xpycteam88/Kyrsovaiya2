package com.example.cw_javacore.controller;

import com.example.cw_javacore.model.Question;
import com.example.cw_javacore.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class ExaminerController {
    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("{amount}")
    public Collection<Question> getQuestions (@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
