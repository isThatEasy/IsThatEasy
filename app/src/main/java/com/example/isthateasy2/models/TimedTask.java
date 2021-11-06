package com.example.isthateasy2.models;

import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.Date;

public class TimedTask extends Task{
    private Timestamp startDate;
    private Timestamp endDate;

    public TimedTask(String title, String level, String course, String topic, String teacherName, String description, Timestamp startDate, Timestamp endDate) {
        super(title, level, course, topic, teacherName, description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TimedTask(String title, String level, String course, String topic, String teacherName, String description, ArrayList<Question> questions, String className, int id, Timestamp createdAt, Timestamp updatedAt, Timestamp startDate, Timestamp endDate) {
        super(title, level, course, topic, teacherName, description, questions, className, id, createdAt, updatedAt);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TimedTask(Timestamp startDate, Timestamp endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TimedTask(Task task, Timestamp startDate, Timestamp endDate) {
        super(task);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TimedTask() {
        super();
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }
    public void setStartDate(String startDate) {
        try {
            this.startDate = new Timestamp(new Date(startDate));
        }
        catch (Exception e){
            this.startDate = null;
        }
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
    public void setEndDate(String endDate) {
        try {
            this.endDate = new Timestamp(new Date(endDate));
        }
        catch (Exception e){
            this.endDate = null;
        }
    }
}
