package com.example.isthateasy2.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskForDisplay {
    private String title;
    private String level;
    private String course;
    private String topic;
    private String teacherName;
    private String description;
    private ArrayList<HashMap<String, Object> >questions;
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public ArrayList<HashMap<String, Object>> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<HashMap<String, Object>> questions) {
        this.questions = questions;
    }

    public TaskForDisplay(String title, String level, String course, String topic, String teacherName, String description) {
        this.title = title;
        this.level = level;
        this.course = course;
        this.topic = topic;
        this.teacherName = teacherName;
        this.description = description;

        questions = new ArrayList<>();
    }

    public TaskForDisplay() {
        questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}