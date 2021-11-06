package com.example.isthateasy2.models;

import com.google.firebase.Timestamp;

import java.util.ArrayList;

public class TypingQuestion extends Question{
    private Answer answer;

    public TypingQuestion(Answer answer) {
        this.answer = answer;
    }

    public TypingQuestion(String question, ArrayList options, String answer, String marks, Answer answer1) {
        super(question, options, answer, marks);
        this.answer = answer1;
    }

    public TypingQuestion(Question question, Answer answer) {
        super(question);
        this.answer = answer;
    }

    public TypingQuestion(String question, ArrayList<String> options, String answer, ArrayList<String> answers, String marks, String wayOfAnswering, Timestamp createdAt, Timestamp updatedAt) {
        super(question, options, answer, answers, marks, wayOfAnswering, createdAt, updatedAt);
    }

    public Answer getCorrectAnswer() {
        return answer;
    }

    public void setCorrectAnswer(Answer answer) {
        this.answer = answer;
    }
}
