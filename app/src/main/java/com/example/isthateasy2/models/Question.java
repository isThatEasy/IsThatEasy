package com.example.isthateasy2.models;


import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> options;
    private String answer;
    private String marks;
    private String wayOfAnswering;

    public String getWayOfAnswering() {
        return wayOfAnswering;
    }

    public void setWayOfAnswering(String wayOfAnswering) {
        this.wayOfAnswering = wayOfAnswering;
    }

    public Question() {
        options = new ArrayList<>();
    }
    public Question(String question, ArrayList options, String answer, String marks) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.marks = marks;
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
