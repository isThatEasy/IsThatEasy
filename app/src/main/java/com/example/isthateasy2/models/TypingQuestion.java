package com.example.isthateasy2.models;

public class TypingQuestion extends Question{
    TypingQuestion(){
        super(C.TYPING_WAY_OF_ANSWERING);
    }
    @Override
    public void setAnswerObject(Object answer){
        answerObject = (Answer) answer;
    }
    public void setAnswer(Answer answer){
        this.answerObject = answer;
    }
    public Answer getAnswer(){
        return (Answer)answerObject;
    }

}
