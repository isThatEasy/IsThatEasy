package com.example.isthateasy2;

import com.example.isthateasy2.models.School;
import com.example.isthateasy2.models.User;

public class SchoolOwnerUser extends User {
    School school;

    public School getSchool() {
        return school;
    }

    public SchoolOwnerUser() {
        super("owner");
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public SchoolOwnerUser(School school) {
        super("owner");
        this.school = school;
    }

    public SchoolOwnerUser(String uId, School school) {
        super("owner", uId);
        this.school = school;
    }

}
