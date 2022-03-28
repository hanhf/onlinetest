package com.hanhf.onlinetest.controller;

import com.hanhf.onlinetest.bean.User;
import com.hanhf.onlinetest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/onlinetest/api/v1/")
@CrossOrigin
public class UserController {
    private UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void insert(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "/users/batch", method = RequestMethod.POST)
    public void batch(String names) {
        String[] nameArr = names.split(",");
        for (String name : nameArr) {
            User user = new User();
            user.setName(name);
            user.setPwd("888888");
            userMapper.insert(user);
        }
    }

//    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable("id") Integer id) {
//        userMapper.delete(id);
//    }
//
//    @RequestMapping(value = "/users", method = RequestMethod.PUT)
//    public Integer update(User user) {
//        return userMapper.update(user);
//    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id) {
        return userMapper.findById(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findList() {
        return userMapper.findList();
    }

    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    public List<User> findListByCondition(User user) {
        return userMapper.findListByCondition(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public int login(User user) {
        User result = userMapper.findByName(user.getName());
        if (result.getPwd().equals(user.getPwd())) {
            return result.getId();
        } else {
            return -1;
        }
    }
}
