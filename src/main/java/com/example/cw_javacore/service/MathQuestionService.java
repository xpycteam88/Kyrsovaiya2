package com.example.cw_javacore.service;

import com.example.cw_javacore.exceptions.MethodNotAllowedException;
import com.example.cw_javacore.model.Question;
import com.example.cw_javacore.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service("math")
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();


    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        var firstNum = generateNum();
        var secondNum = generateNum();
        var operator = generateOperator();
        String textQuestion = firstNum + operator + secondNum;
        String answer;
        var result = 0;
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                answer = result + "";
                return new Question(textQuestion, answer);
            case "-":
                result = firstNum - secondNum;
                answer = result + "";
                return new Question(textQuestion, answer);
            case "*":
                result = firstNum * secondNum;
                answer = result + "";
                return new Question(textQuestion, answer);
            case "/":
                result = firstNum / secondNum;
                answer = result + "";
                return new Question(textQuestion, answer);

        }
        /*
        var questions = repository.getAll();
        int index = random.nextInt(questions.size());
        int i = 0;
        for (Question question : questions) {
            if (index == i) {
                return question;
            }
            i++;
        }
        throw new NotFoundQuestionsException();

         */
        return null;
    }

    private int generateNum() {
        int randomNum = random.nextInt(11);
        if (randomNum == 0) {
            randomNum = generateNum();
        }
        return randomNum;

    }

    private String generateOperator() {
        String[] operators = {"+", "-", "*", "/"};
        int i = random.nextInt(4);
        return operators[i];
    }
}
