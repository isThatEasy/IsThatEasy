package com.example.isthateasy2.models;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskResult implements Serializable {
    private int totalMarks;
    private Task task;
    private boolean isMarked;
    private ArrayList<AnsweredQuestion> answeredQuestions;
    private Timestamp workedAt;

    public void addAnsweredQuestion(AnsweredQuestion answeredQuestion){
        if(answeredQuestions == null)
            answeredQuestions = new ArrayList<>();
        answeredQuestions.add(answeredQuestion);
    }

    public TaskResult(int totalMarks, Task task, boolean isMarked, ArrayList<AnsweredQuestion> answeredQuestions, Timestamp workedAt) {
        this.totalMarks = totalMarks;
        this.task = task;
        this.isMarked = isMarked;
        this.answeredQuestions = answeredQuestions;
        this.workedAt = workedAt;
    }

    public TaskResult() {
        answeredQuestions = new ArrayList<>();
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public ArrayList<AnsweredQuestion> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(ArrayList<AnsweredQuestion> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public Timestamp getWorkedAt() {
        return workedAt;
    }

    public void setWorkedAt(Timestamp workedAt) {
        this.workedAt = workedAt;
    }
}
