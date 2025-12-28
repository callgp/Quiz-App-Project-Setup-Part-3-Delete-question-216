package com.gp.demo.controller;

import com.gp.demo.Question;
import com.gp.demo.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuizController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
         return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionBYCategory(@PathVariable String category){
       return questionService.getQuestionBYCategory(category);
   }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
       // return "success";
    }
    @PutMapping("{id}")
    public Question updateQuestion(@PathVariable Integer id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }
}
