package com.gp.demo.service;

import com.gp.demo.Question;
import com.gp.demo.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionBYCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
         questionDao.save(question);
         return "success";
    }
}
