package com.example.springandajax.controller;

import com.example.springandajax.model.Answer;
import com.example.springandajax.model.Question;
import com.example.springandajax.service.impl.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping
    public ResponseEntity<Iterable<Question>> findAll(){
        return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);

}

    @GetMapping("/{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id){
        Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionOptional.get(), HttpStatus.OK);
    }
    //Tạo mới
    @PostMapping
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question){
        return new ResponseEntity<>(questionService.save(question), HttpStatus.CREATED);
    }

    //Chỉnh sửa
    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@RequestBody Question question, @PathVariable Long id){

        Optional<Question> questionOptional = questionService.findById(id);
        if(!questionOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        question.setId(questionOptional.get().getId());
        questionService.save(question);
        return new ResponseEntity<>(question,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable Long id) {
        java.util.Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        questionService.remove(id);
        return new ResponseEntity<>(questionOptional.get(), HttpStatus.NO_CONTENT);
    }
    }
