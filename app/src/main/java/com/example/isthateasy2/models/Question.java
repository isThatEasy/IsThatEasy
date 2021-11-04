package com.example.isthateasy2.models;


import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private String question;
    private ArrayList<String> options;
    private String answer;
    private ArrayList<String> answers;
    private String marks;
    private String wayOfAnswering;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public String getWayOfAnswering() {
        return wayOfAnswering;
    }

    public void setWayOfAnswering(String wayOfAnswering) {
        this.wayOfAnswering = wayOfAnswering;
    }

    public Question() {
        options = new ArrayList<>();
        answers = new ArrayList<>();
    }
    public Question(String question, ArrayList options, String answer, String marks) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.marks = marks;
    }
    public Question(Question question){
        this.question =question.getQuestion();
        this.options = question.getOptions();
        this.answer = question.getAnswer();
        this.marks = question.getMarks();
        this.wayOfAnswering = question.getWayOfAnswering();
        this.answers = question.answers;
    }

    public Question(String question, ArrayList<String> options, String answer, ArrayList<String> answers, String marks, String wayOfAnswering, Timestamp createdAt, Timestamp updatedAt) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.answers = answers;
        this.marks = marks;
        this.wayOfAnswering = wayOfAnswering;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
    public void addAnswer(String answer){
        answers.add(answer);
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList getOptions() {
        return options;
    }

    public void setOptions(ArrayList options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks){
        this.marks = marks;
    }

    public void addOption(String option){
        options.add(option);
    }
}
