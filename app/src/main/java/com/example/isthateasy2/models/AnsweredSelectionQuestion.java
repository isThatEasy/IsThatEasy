package com.example.isthateasy2.models;

import com.google.firebase.Timestamp;

import java.util.ArrayList;

public class AnsweredSelectionQuestion extends SelectionQuestion{
    private String marksForQuestion;
    private ArrayList<Answer> studentAnswers;

    public void addStudentAnswer(Answer answer) {
        if(studentAnswers == null)
            studentAnswers = new ArrayList<>();
        studentAnswers.add(answer);
    }


    public AnsweredSelectionQuestion(String marksForQuestion, ArrayList<Answer> studentAnswers) {
        this.marksForQuestion = marksForQuestion;
        this.studentAnswers = studentAnswers;
    }

    public AnsweredSelectionQuestion(ArrayList<Answer> answerObject, String type, String marksForQuestion, ArrayList<Answer> studentAnswers) {
        super(answerObject, type);
        this.marksForQuestion = marksForQuestion;
        this.studentAnswers = studentAnswers;
    }

    public AnsweredSelectionQuestion(String question, String marks, Timestamp createdAt, Timestamp updatedAt, int id, ArrayList<Answer> answerObject, String type, String marksForQuestion, ArrayList<Answer> studentAnswers) {
        super(question, marks, createdAt, updatedAt, id, answerObject, type);
        this.marksForQuestion = marksForQuestion;
        this.studentAnswers = studentAnswers;
    }

    public AnsweredSelectionQuestion() {
    }

    public String getMarksForQuestion() {
        return marksForQuestion;
    }

    public void setMarksForQuestion(String marksForQuestion) {
        this.marksForQuestion = marksForQuestion;
    }

    public ArrayList<Answer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(ArrayList<Answer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }
}
