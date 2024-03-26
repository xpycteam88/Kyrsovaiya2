package com.example.cw_javacore.service;

import com.example.cw_javacore.exceptions.NotEnoughQuestionsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    JavaQuestionService javaQuestionService;

    @Mock
    MathQuestionService mathQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    void testGetQuestions() {
      //  assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(1000));
    }

}