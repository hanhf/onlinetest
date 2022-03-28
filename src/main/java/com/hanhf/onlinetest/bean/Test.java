package com.hanhf.onlinetest.bean;

public class Test {
    private Integer userId;
    private Integer questionId;
    private String answer;
    private Integer score;

    public Test() {
    }

    public Test(Integer userId, Integer questionId, String answer, Integer score) {
        this.userId = userId;
        this.questionId = questionId;
        this.answer = answer;
        this.score = score;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
