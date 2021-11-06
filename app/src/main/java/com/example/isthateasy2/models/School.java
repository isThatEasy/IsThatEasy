package com.example.isthateasy2.models;

import java.io.Serializable;
import java.util.ArrayList;

public class School implements Serializable {
    private String id;
    private String headMaster;
    private String location;
    private String type;
    private String owner;
    private ArrayList<Level> levels;
    private String contactEmail;
    private String telephone;
    private String loginPassword;

    public void addLevel(Level level){
        if(levels == null)
            levels = new ArrayList<>();
        levels.add(level);
    }
    public School() {
    }

    public School(String id, String headMaster, String location, String type, String owner, ArrayList<Level> levels, String contactEmail, String telephone, String loginPassword) {
        this.id = id;
        this.headMaster = headMaster;
        this.location = location;
        this.type = type;
        this.owner = owner;
        this.levels = levels;
        this.contactEmail = contactEmail;
        this.telephone = telephone;
        this.loginPassword = loginPassword;
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

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
