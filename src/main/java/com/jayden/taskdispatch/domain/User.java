package com.jayden.taskdispatch.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙勇军（089245）
 * @since 2019/11/30
 */
public class User {
    private String name;
    private int workEfficiency;
    private int attendanceTime;
    private int usedTaskUnit;

    private final int taskUnitCapacity;
    private int curUsedTaskUnit;
    private int curFreeTaskUnit;

    private List<Task> taskList = new ArrayList<>();

    public User(String name, int workEfficiency, int attendanceTime, int usedTaskUnit) {
        this.name = name;
        this.workEfficiency = workEfficiency;
        this.attendanceTime = attendanceTime;
        this.usedTaskUnit = usedTaskUnit;
        this.taskUnitCapacity = workEfficiency * attendanceTime;
        this.curUsedTaskUnit = usedTaskUnit;
        this.curFreeTaskUnit = taskUnitCapacity - curUsedTaskUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWorkEfficiency() {
        return workEfficiency;
    }

    public void setWorkEfficiency(int workEfficiency) {
        this.workEfficiency = workEfficiency;
    }

    public int getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(int attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public int getUsedTaskUnit() {
        return usedTaskUnit;
    }

    public void setUsedTaskUnit(int usedTaskUnit) {
        this.usedTaskUnit = usedTaskUnit;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public float getWorkPercent() {
        return curUsedTaskUnit * 1.0f / taskUnitCapacity;
    }

    public float getCurFreeTaskUnit() {
        return curFreeTaskUnit;
    }

    public void addTask(Task task) {
        taskList.add(task);
        curFreeTaskUnit -= task.getConsumeTaskUnit();
        curUsedTaskUnit += task.getConsumeTaskUnit();
    }

    public int getTaskUnitCapacity() {
        return taskUnitCapacity;
    }

    public int getCurUsedTaskUnit() {
        return curUsedTaskUnit;
    }
}
