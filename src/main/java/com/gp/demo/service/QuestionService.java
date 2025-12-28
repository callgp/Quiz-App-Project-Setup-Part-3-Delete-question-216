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

    public Question updateQuestion(Integer id, Question updatedQuestion) {
        Question existing = questionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        existing.setCategory(updatedQuestion.getCategory());
        existing.setDifficultylevel(updatedQuestion.getDifficultylevel());
        existing.setOption1(updatedQuestion.getOption1());
        existing.setOption2(updatedQuestion.getOption2());
        existing.setOption3(updatedQuestion.getOption3());
        existing.setOption4(updatedQuestion.getOption4());
        existing.setQuestionTitle(updatedQuestion.getQuestionTitle());
        existing.setRightAnswer(updatedQuestion.getRightAnswer());

        return questionDao.save(existing);
    }

    public void deleteQuestion(Integer id) {
        questionDao.deleteById(id);
    }
}
