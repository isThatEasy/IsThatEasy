package com.example.isthateasy2.models;


import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable{
    private String question;
    protected Object answerObject;
    private String marks; // maxMarks
    private String wayOfAnswering;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int id;

    public Question(String wayOfAnswering) {
        this.wayOfAnswering = wayOfAnswering;
    }

    public Question(String question, String marks, String wayOfAnswering, Timestamp createdAt, Timestamp updatedAt, int id) {
        this.question = question;
        this.marks = marks;
        this.wayOfAnswering = wayOfAnswering;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
    }

    public Question(String question, Object answerObject, String marks, String wayOfAnswering, Timestamp createdAt, Timestamp updatedAt, int id) {
        this.question = question;
        this.answerObject = answerObject;
        this.marks = marks;
        this.wayOfAnswering = wayOfAnswering;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public void setAnswerObject(Object answerObject) {
        this.answerObject = answerObject;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getWayOfAnswering() {
        return wayOfAnswering;
    }

    public void setWayOfAnswering(String wayOfAnswering) {
        this.wayOfAnswering = wayOfAnswering;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
