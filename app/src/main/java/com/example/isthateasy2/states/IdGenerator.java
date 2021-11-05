package com.example.isthateasy2.states;

public class IdGenerator {
    static int listOfClassIdGenerator = 0;
    static int questionsRecyclerIds;
    public static int getNewClassId(){
        return ++listOfClassIdGenerator;
    }
    public static int getQuestionId(){
        return ++questionsRecyclerIds;
    }
}
