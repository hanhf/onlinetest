package com.hanhf.onlinetest.controller;

import com.hanhf.onlinetest.bean.Question;
import com.hanhf.onlinetest.bean.Test;
import com.hanhf.onlinetest.bean.User;
import com.hanhf.onlinetest.mapper.QuestionMapper;
import com.hanhf.onlinetest.mapper.TestMapper;
import com.hanhf.onlinetest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/onlinetest/api/v1/")
@CrossOrigin
public class TestController {
    private TestMapper testMapper;
    private QuestionMapper questionMapper;
    private UserMapper userMapper;
    private List<User> userList;
    private List<Question> questionList;
    private Map<Integer, Queue<Question>> userQuestionMap;

    @Autowired
    public TestController(TestMapper testMapper, QuestionMapper questionMapper, UserMapper userMapper) {
        this.testMapper = testMapper;
        this.questionMapper = questionMapper;
        this.userMapper = userMapper;

        this.userList = this.userMapper.findList();
        this.questionList = this.questionMapper.findList();
        this.userQuestionMap = new HashMap<>();
        for (User user : this.userList) {
            Queue<Question> queue = new LinkedList<>();
            List<Question> temp = new ArrayList<>();
            temp.addAll(this.questionList);
            Collections.shuffle(temp);
            queue.addAll(temp);
            this.userQuestionMap.put(user.getId(), queue);
        }
    }

    @RequestMapping(value = "/test/next", method = RequestMethod.GET)
    public Question getQuestion(Integer userId) {
        Queue<Question> queue = userQuestionMap.get(userId);
        return queue.poll();
    }

    @RequestMapping(value = "/test/commit", method = RequestMethod.POST)
    public void answer(Test test) {
        testMapper.insert(test);
    }

    @RequestMapping(value = "/test/result", method = RequestMethod.GET)
    public List<Test> getResult(Integer userId) {
        return testMapper.findListByUserId(userId);
    }
}
