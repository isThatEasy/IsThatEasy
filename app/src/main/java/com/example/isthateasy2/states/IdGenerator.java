package com.example.isthateasy2.states;

public class IdGenerator {
    static int buttonIds= 0;
    public static int getNewButtonId(){
        return ++buttonIds;
    }
}
