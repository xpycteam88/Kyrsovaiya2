package com.example.cw_javacore.repository;

import com.example.cw_javacore.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    JavaQuestionRepository repository = new JavaQuestionRepository();


    @Test
    void testAdd() {
        repository.add(new Question("Sky", "Eng"));
        repository.add("Pro", "Sky");
        assertEquals(2, repository.getAll().size());
        assertThat(repository.getAll()).containsExactlyInAnyOrder(
                new Question("Sky", "Eng"),
                new Question("Pro", "Sky"));

    }

    @Test
    void remove() {
        repository.add(new Question("Sky", "Eng"));
        repository.add("Pro", "Sky");
        var expected = repository.remove(new Question("Sky", "Eng"));
        assertThat(expected).isEqualTo(new Question("Sky", "Eng"));
        var expected2 = repository.remove(new Question("Hex", "Let"));
        assertNull(expected2);
        assertThat(repository.getAll()).containsExactlyInAnyOrder(
                new Question("Pro", "Sky"));
    }

}