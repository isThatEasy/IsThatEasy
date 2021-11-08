package com.example.isthateasy2.models;


public class AnsweredTypingQuestion extends TypingQuestion{
    private String marksForQuestion;
    private Answer studentAnswer;

    public AnsweredTypingQuestion(String marksForQuestion, Answer studentAnswer) {
        this.marksForQuestion = marksForQuestion;
        this.studentAnswer = studentAnswer;
    }

    public String getMarksForQuestion() {
        return marksForQuestion;
    }

    public void setMarksForQuestion(String marksForQuestion) {
        this.marksForQuestion = marksForQuestion;
    }

    public Answer getStudentAnswer() {
        return studentAnswer;
    }

    public void setStudentAnswer(Answer studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
}
