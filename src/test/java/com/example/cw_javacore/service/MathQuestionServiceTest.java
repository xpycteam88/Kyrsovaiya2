package com.example.cw_javacore.service;

import com.example.cw_javacore.exceptions.MethodNotAllowedException;
import com.example.cw_javacore.model.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionServiceTest {

    private final MathQuestionService service = new MathQuestionService();

    @Test
    void testAddString() {
        assertThrows(MethodNotAllowedException.class, () -> service.add("Sky", "Pro"));
    }

    @Test
    void testAddQuestion() {
        assertThrows(MethodNotAllowedException.class, () -> service.add(new Question("Sky", "Pro")));
    }

    @Test
    void testRemove() {
        assertThrows(MethodNotAllowedException.class, () -> service.remove(new Question("Sky", "Pro")));
    }

    @Test
    void testGetAll() {
        assertThrows(MethodNotAllowedException.class, () -> service.getAll());
    }
}