package com.example.isthateasy2.models;

import java.io.Serializable;
import java.util.ArrayList;

// same as Topic
public class Chapter implements Serializable {
    private int id;
    private String name;
    private ArrayList<Chapter> subChapters;

    public void addSubChapter(Chapter chapter){
        if(subChapters == null)
            subChapters = new ArrayList<>();
        subChapters.add(chapter);
    }

    public Chapter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Chapter(int id, String name, ArrayList<Chapter> subChapters) {
        this.id = id;
        this.name = name;
        this.subChapters = subChapters;
    }

    public Chapter() {
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

    public ArrayList<Chapter> getSubChapters() {
        return subChapters;
    }

    public void setSubChapters(ArrayList<Chapter> subChapters) {
        this.subChapters = subChapters;
    }
}
