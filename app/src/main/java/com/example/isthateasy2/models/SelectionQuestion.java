package com.example.isthateasy2.models;

import android.util.Log;

import com.google.firebase.Timestamp;

import java.util.ArrayList;
import java.util.Map;

public class SelectionQuestion extends Question{
    private static final String TAG = "SelectionQuestion";
    private String type; // like multiplechoose, dropdown

    public SelectionQuestion() {
        super(C.SELECTION_WAY_OF_ANSWERING);
    }

    public SelectionQuestion(ArrayList<Answer> answerObject, String type) {
        super(C.SELECTION_WAY_OF_ANSWERING);
        this.answerObject = answerObject;
        this.type = type;
    }

    public SelectionQuestion(String question, String marks, Timestamp createdAt, Timestamp updatedAt, int id, ArrayList<Answer> answerObject, String type) {
        super(question, marks, C.SELECTION_WAY_OF_ANSWERING, createdAt, updatedAt, id);
        this.answerObject = answerObject;
        this.type = type;
    }


    public ArrayList<Answer> getAnswerObject() {
        return  (ArrayList<Answer>) this.answerObject;
    }

    public void setAnswerObjectArray(ArrayList<Answer> answerObject) {
       this.answerObject = answerObject;
    }
    public void setAnswerObjectMap(ArrayList<Map<String, Object>> answerObjectMap){
        if (answerObject == null)
            answerObject = new ArrayList<>();
        if(answerObjectMap == null){
            return;
        }
        try {
            for (Map<String, Object> ans : answerObjectMap) {
                Answer answer = new Answer();
                try {
                    answer.setAnswer((String) ans.get("answer"));
                    answer.setIsItCorrectString(ans.get("IsItCorrect"));
                }
                catch (Exception e){
                    Log.e(TAG, "setAnswerObjectMap: Error occur" );

                }

                addPossibleAnswer(answer);

            }
        }
        catch (Exception exception){
            Log.e(TAG, "setAnswerObjectMap: "+exception.toString() );
        }

    }
    public void addPossibleAnswer(Answer answer){
        if (answerObject == null){
            answerObject = new ArrayList<>();
        }
        ((ArrayList<Answer>)answerObject).add(answer);
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public void setAnswerObject(Object answerObject){
        this.answerObject = (ArrayList<Answer>) answerObject;
    }
}
