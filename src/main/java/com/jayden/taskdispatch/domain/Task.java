package com.jayden.taskdispatch.domain;

/**
 * @author 孙勇军（089245）
 * @since 2019/11/30
 */
public class Task {
    private int id;
    private int priority;
    private int complexity;
    private User user;

    public Task(int id, int priority, int complexity) {
        this.id = id;
        this.priority = priority;
        this.complexity = complexity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getConsumeTaskUnit() {
        return complexity;
    }
}
