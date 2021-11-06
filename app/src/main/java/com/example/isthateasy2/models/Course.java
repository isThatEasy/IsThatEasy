package com.example.isthateasy2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Course implements Serializable {
    private int id;
    private String name;
    private String cId;
    private ArrayList<Chapter> chapters;

    public void addChapter(Chapter chapter){
        if (chapters == null){
            chapters = new ArrayList<>();
        }
        chapters.add(chapter);
    }
    public Course(Map<String, Object> course){
        this.name = (String)course.get("name");
    }


    public Course(int id, String name, String cId, ArrayList<Chapter> chapters) {
        this.id = id;
        this.name = name;
        this.cId = cId;
        this.chapters = chapters;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }
}
