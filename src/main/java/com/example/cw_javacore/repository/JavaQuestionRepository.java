package com.example.cw_javacore.repository;

import com.example.cw_javacore.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("javaRepository")
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> repository = new HashSet<>();

    @PostConstruct
    private void init() {
        repository.add(new Question("Pro", "Sky"));
        repository.add(new Question("Sky", "Eng"));
        repository.add(new Question("Du", "Hast"));
        repository.add(new Question("Ich", "Will"));
        repository.add(new Question("Links", "2 3 4"));
        repository.add(new Question("Ohne", "Dich"));
    }


    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        repository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (repository.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(repository);
    }
}
