package com.example.isthateasy2.adapters;

import com.example.isthateasy2.models.Question;

public class Answer {
    private Question question;
    private String answer;
    private boolean isItCorrect;
    private boolean isAnswered;


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isItCorrect() {
        return isItCorrect;
    }

    public void setItCorrect(boolean itCorrect) {
        isItCorrect = itCorrect;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}
