package com.hanhf.onlinetest.controller;

import com.hanhf.onlinetest.bean.Question;
import com.hanhf.onlinetest.bean.User;
import com.hanhf.onlinetest.mapper.QuestionMapper;
import com.hanhf.onlinetest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/onlinetest/api/v1/")
@CrossOrigin
public class QuestionController {
    private QuestionMapper questionMapper;

    @Autowired
    public QuestionController(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public void insert(Question question) {
        questionMapper.insert(question);
    }

    @RequestMapping(value = "/questions/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        questionMapper.delete(id);
    }

    @RequestMapping(value = "/questions", method = RequestMethod.PUT)
    public Integer update(Question question) {
        return questionMapper.update(question);
    }

    @RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
    public Question findById(@PathVariable("id") Integer id) {
        return questionMapper.findById(id);
    }

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public List<Question> findList() {
        return questionMapper.findList();
    }

    @RequestMapping(value = "/questions/search", method = RequestMethod.GET)
    public List<Question> findListByCondition(Question question) {
        return questionMapper.findListByCondition(question);
    }
}
