package com.example.isthateasy2.models;

import android.util.Log;

import java.io.Serializable;


//same as option
public class Answer implements Serializable {
    private String id;
    private String answer;
    private boolean isItCorrect;

    public Answer(String answer, String isItCorrect) {
        this.answer = answer;
        try {
            this.isItCorrect =Boolean.getBoolean(isItCorrect);
        }
        catch (Exception e){
            Log.e("converting error", "Answer: fail to convert isItCorrect to boolean");
        }

    }
    public Answer(String answer, boolean isItCorrect) {
        this.answer = answer;
        this.isItCorrect = isItCorrect;
    }

    public Answer(String id, String answer, String isItCorrect) {
        this.id = id;
        this.answer = answer;
        try {
            this.isItCorrect =Boolean.getBoolean(isItCorrect) ;
        }
        catch (Exception e){
            Log.e("converting error", "Answer: fail to convert isItCorrect to boolean");
        }

    }
    public Answer(String id, String answer, Boolean isItCorrect) {
        this.id = id;
        this.answer = answer;
        this.isItCorrect = isItCorrect;
    }

    public Answer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getIsItCorrect() {
        return isItCorrect;
    }

    public void setIsItCorrectString(Object isItCorrect) {
        try {
            this.isItCorrect =Boolean.getBoolean((String) isItCorrect) ;
        }
        catch (Exception e){
            Log.e("converting error", "Answer: fail to convert isItCorrect to boolean");
        }
    }
    public void setIsItCorrect(boolean isItCorrect) {
        this.isItCorrect = isItCorrect;
    }
}
