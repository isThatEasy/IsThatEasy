package com.example.isthateasy2.models;

import java.util.ArrayList;

public class TeacherUser extends User{
    private ArrayList<Classes> classes;//attention on this with classes class
    private School school;
    private String degree;

    public void addClass(Classes class_){
        if(classes == null)
            classes = new ArrayList<>();
        classes.add(class_);
    }

    public TeacherUser(String firstName, String secondName, ArrayList<Classes> classes, School school, String degree) {
        super(firstName, secondName, "Teacher");
        this.classes = classes;
        this.school = school;
        this.degree = degree;
    }

    public TeacherUser(ArrayList<Classes> classes, School school, String degree) {
        super("Teacher");
        this.classes = classes;
        this.school = school;
        this.degree = degree;
    }

    public TeacherUser() {
        super("Teacher");
    }

    public ArrayList<Classes> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classes> classes) {
        this.classes = classes;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
