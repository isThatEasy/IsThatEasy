package com.example.isthateasy2.models;

import com.google.firebase.Timestamp;

import java.util.ArrayList;

public class AnsweredQuestion extends Question{
    private String marksAtQuestion;
    private ArrayList<Answer> studentAnswers;

    public void addStudentAnswer(Answer answer) {
        if(studentAnswers == null)
            studentAnswers = new ArrayList<>();
        studentAnswers.add(answer);
    }

    public AnsweredQuestion(String marksAtQuestion, ArrayList<Answer> studentAnswers) {
        this.marksAtQuestion = marksAtQuestion;
        this.studentAnswers = studentAnswers;
    }

    public AnsweredQuestion(String question, ArrayList options, String answer, String marks, String marksAtQuestion, ArrayList<Answer> studentAnswers) {
        super(question, options, answer, marks);
        this.marksAtQuestion = marksAtQuestion;
        this.studentAnswers = studentAnswers;
    }

    public AnsweredQuestion(Question question, String marksAtQuestion, ArrayList<Answer> studentAnswers) {
        super(question);
        this.marksAtQuestion = marksAtQuestion;
        this.studentAnswers = studentAnswers;
    }

    public AnsweredQuestion(String question, ArrayList<String> options, String answer, ArrayList<String> answers, String marks, String wayOfAnswering, Timestamp createdAt, Timestamp updatedAt, String marksAtQuestion, ArrayList<Answer> studentAnswers) {
        super(question, options, answer, answers, marks, wayOfAnswering, createdAt, updatedAt);
        this.marksAtQuestion = marksAtQuestion;
        this.studentAnswers = studentAnswers;
    }

    public AnsweredQuestion() {
        super();
    }

    public String getMarksAtQuestion() {
        return marksAtQuestion;
    }

    public void setMarksAtQuestion(String marksAtQuestion) {
        this.marksAtQuestion = marksAtQuestion;
    }

    public ArrayList<Answer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(ArrayList<Answer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }
}
