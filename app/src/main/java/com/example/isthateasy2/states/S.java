package com.example.isthateasy2.states;

import com.example.isthateasy2.models.User;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class S {
    private static FirebaseUser user;
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static User userInfo;

    public static User getUserInfo() {
        return userInfo;
    }

    public static void setUserInfo(User userInfo) {
        S.userInfo = userInfo;
    }

    public static FirebaseUser getUser() {
        return user;
    }

    public static void setUser(FirebaseUser user) {
        S.user = user;
    }

    public static FirebaseFirestore getDb() {
        return db;
    }

    public static void setDb(FirebaseFirestore db) {
        S.db = db;
    }
}
