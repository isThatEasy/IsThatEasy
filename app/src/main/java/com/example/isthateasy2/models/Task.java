package com.example.isthateasy2.models;

import androidx.annotation.NonNull;

import com.google.firebase.Timestamp;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {
    private String title;
    private Chapter chapter;
    private String description;
    private ArrayList<Question> questions;
    private Class_ class_;
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private Course course;
    private TeacherUser teacher;
    private Level level;
//    private Class_ taskClass; // created in which class
    private boolean isItPublic = true;
    private boolean showAnswerAfterAttempt = true;

    public Task(String title, String description, ArrayList<Question> questions, int id, Timestamp createdAt, Timestamp updatedAt, TeacherUser teacher, Class_ class_, boolean isItPublic, boolean showAnswerAfterAttempt) {
        this.title = title;
        this.description = description;
        this.questions = questions;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.teacher = teacher;
        this.class_ = class_;
        this.isItPublic = isItPublic;
        this.showAnswerAfterAttempt = showAnswerAfterAttempt;
    }

    public TeacherUser getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherUser teacher) {
        this.teacher = teacher;
    }

    public Class_ getClass_() {
        return class_;
    }

    public void setClass_(Class_ class_) {
        this.class_ = class_;
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
        if(class_ == null){
            return null;
        }
        return class_.getName();
    }

    public void setClassName(String className) {
        if(class_ == null)
            this.class_ = new Class_();
        this.class_.setName(className);
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

    public Task(String title, String level, String courseName, String chapter, String teacherName, String description) {
        this.course = new Course();
        this.teacher = new TeacherUser();
        this.chapter = new Chapter(chapter);
        this.level = new Level(level);

        this.title = title;
        this.course.setName(courseName);
//        this.teacher.setFirstName(teacherName);
        this.description = description;

        questions = new ArrayList<>();
    }

    public Task(String title, String level, String courseName, String chapter, String teacherName, String description, ArrayList<Question> questions, String className, int id, Timestamp createdAt, Timestamp updatedAt) {
        this.course = new Course();
        this.teacher = new TeacherUser();
        this.chapter = new Chapter(chapter);
        this.class_ = new Class_(className);
        this.level = new Level(level);

        this.title = title;
        this.course.setName(courseName);
//        this.teacher.setFirstName(teacherName);
        this.description = description;
        this.questions = questions;
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {
        questions = new ArrayList<>();
    }
    public Task(@NonNull Task task){
        this.title = task.getTitle();
        this.course = task.getCourse();
        this.chapter = task.getChapter();
        this.teacher = task.getTeacher();
        this.description = task.getDescription();
        this.questions = task.getQuestions();
        this.class_ = task.getClass_();
        this.id =task.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String _getLevelName() {
        if(this.level == null)
            return null;
        return this.level.getName();
    }
    public Level getLevel(){
        return this.level;
    }

    public void _setLevelName(String levelName) {
        if(this.level == null)
            this.level = new Level();
        this.level.setName(levelName);
    }
    public void setLevel(Level level){
        this.level = level;
    }

    public String getCourseName() {
        if(course == null)
            return null;
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

    public String getChapterName() {
        return chapter.getName();
    }

    public void setChapterName(String chapterName) {
        if(this.chapter == null)
            chapter = new Chapter();
        this.chapter.setName(chapterName);
    }

    public Chapter getChapter() {
        if(chapter == null)
            return null;
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getTeacherName() {
        if (teacher == null)
            return null;
        return "this.teacher.getFirstName()";
    }

    public void setTeacherName(String teacherName) {
        if(this.teacher == null)
            this.teacher = new TeacherUser();
//        this.teacher.setFirstName(teacherName);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
