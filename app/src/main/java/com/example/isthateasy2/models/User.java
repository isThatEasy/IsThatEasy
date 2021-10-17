package com.example.isthateasy2.models;

public class User {
    private String firstName;
    private String secondName;
    private String typeOfUser;

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
