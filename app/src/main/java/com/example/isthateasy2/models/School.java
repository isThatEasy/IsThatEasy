package com.example.isthateasy2.models;

import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class School implements Serializable {
    private String TAG = "school";



    private String name;
    private String id;
    private String headMaster;
    private String location;
    private String type="primary";
    private String owner;
    private ArrayList<Level> levels;
    private String contactEmail;
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLevel(Level level){
        if(levels == null)
            levels = new ArrayList<>();
        levels.add(level);
    }
    public School() {
    }

    public School(String id, String headMaster, String location, String owner, ArrayList<Level> levels, String contactEmail, String telephone) {
        this.id = id;
        this.headMaster = headMaster;
        this.location = location;
        this.owner = owner;
        this.levels = levels;
        this.contactEmail = contactEmail;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadMaster() {
        return headMaster;
    }

    public void setHeadMaster(String headMaster) {
        this.headMaster = headMaster;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void createLevels(String lowerLevel, String higherLevel) {
        int lower = Integer.parseInt(lowerLevel.substring(1));
        int higher = Integer.parseInt(higherLevel.substring(1));
        for(int i = lower; i<=higher; i++){
            addLevel(new Level("P"+i));
        }
        Log.d(TAG, "createLevels: " + lower);
    }

    public void print() {
        Log.d(TAG, "print: email "+ getContactEmail());
        Log.d(TAG, "print: name "+ getName());
        Log.d(TAG, "print: headMaster "+ getHeadMaster());
    }
}
