package com.example.cw_javacore.service;

import com.example.cw_javacore.exceptions.NotEnoughQuestionsException;
import com.example.cw_javacore.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaService;
    private final QuestionService mathService;

    private final Random random = new Random();

    public ExaminerServiceImpl(@Qualifier("java") QuestionService javaService, @Qualifier("math") QuestionService mathService) {
        this.javaService = javaService;
        this.mathService = mathService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        /*
        var allQuestions = new ArrayList<>(javaService.getAll());

        allQuestions.addAll(mathService.getAll());
        if (amount > allQuestions.size()) {
            throw new NotEnoughQuestionsException();
        }

        if (amount == allQuestions.size()){
            return allQuestions;
        }
        */
        Set<Question> questions = new HashSet<>();
        Question randomQuestion;
        if (javaService.getAll().isEmpty()) {
            while (questions.size() < amount) {
                randomQuestion = mathService.getRandomQuestion();
                questions.add(randomQuestion);
            }
        } else {
            while (questions.size() < amount) {

                randomQuestion = random.nextBoolean() ? javaService.getRandomQuestion() : mathService.getRandomQuestion();
                questions.add(randomQuestion);
            }

        }
        return questions;
    }
}
