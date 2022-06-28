package com.example.springandajax.repository;

import com.example.springandajax.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
