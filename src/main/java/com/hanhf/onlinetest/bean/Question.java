package com.hanhf.onlinetest.bean;

import java.io.Serializable;

public class Question implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private String answer;

    public Question() {
    }

    public Question(Integer id, String title, String content, String answer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
