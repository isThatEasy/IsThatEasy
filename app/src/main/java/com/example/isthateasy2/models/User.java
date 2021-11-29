package com.example.isthateasy2.models;

import java.io.Serializable;

public class User implements Serializable {
    private String typeOfUser;
    private String image;
    private int id;
    private String uId;


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

    public User(String typeOfUser, String uId){
        this.typeOfUser = typeOfUser;
        this.uId = uId;
    }


    public User(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }


    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }
}
