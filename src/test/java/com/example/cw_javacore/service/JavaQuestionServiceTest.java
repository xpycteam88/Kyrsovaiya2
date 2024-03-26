package com.example.cw_javacore.service;

import com.example.cw_javacore.exceptions.NotFoundQuestionsException;
import com.example.cw_javacore.model.Question;
import com.example.cw_javacore.repository.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    static List<Question> QUESTIONS = List.of(new Question("Pro", "Sky"),
            new Question("Sky", "Eng"),
            new Question("Du", "Hast"),
            new Question("Ich", "Will"));

    @Mock
    JavaQuestionRepository repository;

    @InjectMocks
    JavaQuestionService service;

    @BeforeEach
    void setUp() {
        when(repository.getAll()).thenReturn(QUESTIONS);

    }

    @Test
    void testRandomQuestion() {
        for (int i = 0; i < 10 ; i++) {
            assertTrue(QUESTIONS.contains(service.getRandomQuestion()));
        }
        when(repository.getAll()).thenReturn(List.of(new Question("Ich", "Will")));
        assertEquals(new Question("Ich", "Will"), service.getRandomQuestion());


    }

    @Test
    void testEmptyQuestions() {
        when(repository.getAll()).thenReturn(List.of());
        assertThrows(NotFoundQuestionsException.class, () -> service.getRandomQuestion());
    }


}