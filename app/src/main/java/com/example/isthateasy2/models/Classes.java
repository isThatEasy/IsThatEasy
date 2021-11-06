package com.example.isthateasy2.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Classes implements Serializable {
    private String teacherName; // will be deleted
    private String schoolName; //will be deleted
    private String notification; // will be deleted later

    private String classId;
    private School school;
    private TeacherUser teacherUser;
    private Level level;
    private ArrayList<Task> tasks;
    private ArrayList<StudentUser> students; // attension on this with studentUser class
    private String name;

    public void addTask(Task task){
        if(tasks == null)
            tasks = new ArrayList<>();
        tasks.add(task);
    }
    public void addStudent(StudentUser studentUser){
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(studentUser);
    }


    public Classes(String classId, School school, TeacherUser teacherUser, Level level, ArrayList<Task> tasks, ArrayList<StudentUser> students, String name) {
        this.classId = classId;
        this.school = school;
        this.teacherUser = teacherUser;
        this.level = level;
        this.tasks = tasks;
        this.students = students;
        this.name = name;
    }


    public Classes(String teacherName, String schoolName, String notification) {
        this.teacherName = teacherName;
        this.schoolName = schoolName;
        this.notification = notification;
    }

    public Classes() {
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public TeacherUser getTeacherUser() {
        return teacherUser;
    }

    public void setTeacherUser(TeacherUser teacherUser) {
        this.teacherUser = teacherUser;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<StudentUser> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentUser> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
