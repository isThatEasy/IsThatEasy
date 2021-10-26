package com.example.isthateasy2.models;

import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {
    private String title;
    private String level;
    private String course;
    private String topic;
    private String teacherName;
    private String description;
    private ArrayList<Question> questions;
    private String className;
    private int id;
    private static int counter = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Task(String title, String level, String course, String topic, String teacherName, String description) {
        this.title = title;
        this.level = level;
        this.course = course;
        this.topic = topic;
        this.teacherName = teacherName;
        this.description = description;

        questions = new ArrayList<>();
        ++counter;
        this.id =counter;
    }

    public Task() {
        questions = new ArrayList<>();
        ++counter;
        this.id =counter;
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
