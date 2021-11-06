package com.example.isthateasy2.models;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String secondName;
    private String typeOfUser;
    private String password;
    private String image;
    private int id;
    private String uId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public User() {
    }

    public User(String firstName, String secondName, String typeOfUser) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.typeOfUser = typeOfUser;
    }

    public User(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }
}
