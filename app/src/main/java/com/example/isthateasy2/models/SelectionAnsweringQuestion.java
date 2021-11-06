package com.example.isthateasy2.models;

import com.google.firebase.Timestamp;

import java.util.ArrayList;

public class SelectionAnsweringQuestion extends Question{
    private ArrayList<Answer> possibleAnswers;
    private String type; // like multiplechoose, dropdown


    public void addAnswer(String answer) {
        super.addAnswer(answer);
    }

    public SelectionAnsweringQuestion(ArrayList<Answer> possibleAnswers, String type) {
        this.possibleAnswers = possibleAnswers;
        this.type = type;
    }

    public SelectionAnsweringQuestion(String question, ArrayList options, String answer, String marks, ArrayList<Answer> possibleAnswers, String type) {
        super(question, options, answer, marks);
        this.possibleAnswers = possibleAnswers;
        this.type = type;
    }

    public SelectionAnsweringQuestion(Question question, ArrayList<Answer> possibleAnswers, String type) {
        super(question);
        this.possibleAnswers = possibleAnswers;
        this.type = type;
    }

    public SelectionAnsweringQuestion(String question, ArrayList<String> options, String answer, ArrayList<String> answers, String marks, String wayOfAnswering, Timestamp createdAt, Timestamp updatedAt, ArrayList<Answer> possibleAnswers, String type) {
        super(question, options, answer, answers, marks, wayOfAnswering, createdAt, updatedAt);
        this.possibleAnswers = possibleAnswers;
        this.type = type;
    }

    public SelectionAnsweringQuestion() {
        super();
        // we will change it later, make it created when it is needed (like adding answer to it)
        possibleAnswers = new ArrayList<>();
    }

    public ArrayList<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(ArrayList<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
