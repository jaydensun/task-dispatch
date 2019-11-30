package com.jayden.taskdispatch.domain;

import java.util.List;

/**
 * @author 孙勇军（089245）
 * @since 2019/11/30
 */
public class TaskDispatchSolution {
    private List<User> userList;
    private List<Task> taskList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

}
