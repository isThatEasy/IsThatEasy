package com.example.isthateasy2.models;

import androidx.annotation.NonNull;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {
    private String title;
    private String level;
    private String topic;
//    private String teacherName;
    private String description;
    private ArrayList<Question> questions;
    private String className; // will be deleted later
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private Course course;
    private TeacherUser teacher;
    private Classes taskClass; // created in which class
    private boolean isItPublic = true;
    private boolean showAnswerAfterAttempt = true;

    public Task(String title, String description, ArrayList<Question> questions, int id, Timestamp createdAt, Timestamp updatedAt, TeacherUser teacher, Classes taskClass, boolean isItPublic, boolean showAnswerAfterAttempt) {
        this.title = title;
        this.description = description;
        this.questions = questions;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.teacher = teacher;
        this.taskClass = taskClass;
        this.isItPublic = isItPublic;
        this.showAnswerAfterAttempt = showAnswerAfterAttempt;
    }

    public TeacherUser getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherUser teacher) {
        this.teacher = teacher;
    }

    public Classes getTaskClass() {
        return taskClass;
    }

    public void setTaskClass(Classes taskClass) {
        this.taskClass = taskClass;
    }

    public boolean isItPublic() {
        return isItPublic;
    }

    public void setItPublic(boolean itPublic) {
        isItPublic = itPublic;
    }

    public boolean isShowAnswerAfterAttempt() {
        return showAnswerAfterAttempt;
    }

    public void setShowAnswerAfterAttempt(boolean showAnswerAfterAttempt) {
        this.showAnswerAfterAttempt = showAnswerAfterAttempt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }


    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addQuestion(Question question){
        if(questions == null)
            questions = new ArrayList<>();
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Task(String title, String level, String courseName, String topic, String teacherName, String description) {
        this.course = new Course();
        this.teacher = new TeacherUser();

        this.title = title;
        this.level = level;
        this.course.setName(courseName);
        this.topic = topic;
        this.teacher.setFirstName(teacherName);
        this.description = description;

        questions = new ArrayList<>();
    }

    public Task(String title, String level, String courseName, String topic, String teacherName, String description, ArrayList<Question> questions, String className, int id, Timestamp createdAt, Timestamp updatedAt) {
        this.course = new Course();
        this.teacher = new TeacherUser();

        this.title = title;
        this.level = level;
        this.course.setName(courseName);
        this.topic = topic;
        this.teacher.setFirstName(teacherName);
        this.description = description;
        this.questions = questions;
        this.className = className;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {
        questions = new ArrayList<>();
    }
    public Task(@NonNull Task task){
        this.title = task.getTitle();
        this.level = task.getLevel();
        this.course = task.getCourse();
        this.topic = task.getTopic();
        this.teacher = task.getTeacher();
        this.description = task.getDescription();
        this.questions = task.getQuestions();
        this.className = task.getClassName();
        this.id =task.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCourseName() {
        return this.course.getName();
    }
    public Course getCourse(){
        return this.course;
    }

    public void setCourseName(String course) {
        this.course = new Course();
        this.course.setName(course);
    }
    public void setCourse(Course course){
        this.course = course;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTeacherName() {
        if (teacher == null)
            return null;
        return this.teacher.getFirstName();
    }

    public void setTeacherName(String teacherName) {
        if(this.teacher == null)
            this.teacher = new TeacherUser();
        this.teacher.setFirstName(teacherName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
