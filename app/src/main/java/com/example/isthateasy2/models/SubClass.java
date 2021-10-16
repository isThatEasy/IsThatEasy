package com.example.isthateasy2.models;

public class SubClass {
    private String teacherName;
    private String schoolName;
    private String notification;

    public SubClass(String teacherName, String schoolName, String notification) {
        this.teacherName = teacherName;
        this.schoolName = schoolName;
        this.notification = notification;
    }

    public SubClass() {
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
