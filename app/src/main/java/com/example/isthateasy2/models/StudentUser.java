package com.example.isthateasy2.models;

import java.util.ArrayList;

public class StudentUser extends User {
    private ArrayList<TaskResult> taskResults;
    private ArrayList<Class_> enrolledClasses;
    private Level level;
    private School school;

    public void addTaskResult(TaskResult taskResult){
        if (taskResults == null)
            taskResults = new ArrayList<>();
        taskResults.add(taskResult);
    }
    public void addEnrolledClass(Class_ class_){
        if(enrolledClasses == null){
            enrolledClasses = new ArrayList<>();
        }
        enrolledClasses.add(class_);
    }

    public StudentUser() {
    }

    public StudentUser(ArrayList<TaskResult> taskResults, ArrayList<Class_> enrolledClasses, Level level, School school) {
        this.taskResults = taskResults;
        this.enrolledClasses = enrolledClasses;
        this.level = level;
        this.school = school;
    }

    public StudentUser(String firstName, String secondName, String typeOfUser, ArrayList<TaskResult> taskResults, ArrayList<Class_> enrolledClasses, Level level, School school) {
        super(firstName, secondName, typeOfUser);
        this.taskResults = taskResults;
        this.enrolledClasses = enrolledClasses;
        this.level = level;
        this.school = school;
    }

    public StudentUser(String typeOfUser, ArrayList<TaskResult> taskResults, ArrayList<Class_> enrolledClasses, Level level, School school) {
        super(typeOfUser);
        this.taskResults = taskResults;
        this.enrolledClasses = enrolledClasses;
        this.level = level;
        this.school = school;
    }

    public ArrayList<TaskResult> getTaskResults() {
        return taskResults;
    }

    public void setTaskResults(ArrayList<TaskResult> taskResults) {
        this.taskResults = taskResults;
    }

    public ArrayList<Class_> getEnrolledClasses() {
        return enrolledClasses;
    }

    public void setEnrolledClasses(ArrayList<Class_> enrolledClasses) {
        this.enrolledClasses = enrolledClasses;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
