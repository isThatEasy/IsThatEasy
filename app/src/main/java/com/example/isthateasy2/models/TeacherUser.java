package com.example.isthateasy2.models;

import java.util.ArrayList;

public class TeacherUser extends User{
    private ArrayList<Class_> aClasses;//attention on this with classes class
    private School school;
    private String degree;

    public void addClass(Class_ class_){
        if(aClasses == null)
            aClasses = new ArrayList<>();
        aClasses.add(class_);
    }

    public TeacherUser(String firstName, String secondName, ArrayList<Class_> aClasses, School school, String degree) {
        super(firstName, secondName, "Teacher");
        this.aClasses = aClasses;
        this.school = school;
        this.degree = degree;
    }

    public TeacherUser(ArrayList<Class_> aClasses, School school, String degree) {
        super("Teacher");
        this.aClasses = aClasses;
        this.school = school;
        this.degree = degree;
    }

    public TeacherUser() {
        super("Teacher");
    }

    public ArrayList<Class_> getClasses() {
        return aClasses;
    }

    public void setClasses(ArrayList<Class_> aClasses) {
        this.aClasses = aClasses;
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
