package com.example.isthateasy2.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Question;
import com.example.isthateasy2.models.Task;
import com.example.isthateasy2.states.IdGenerator;

public class QuizQuestionViewHolder extends RecyclerView.ViewHolder {
    TextView course,level, teacherName, title, description,topic;
    Button attempt;
    TextView questionField;

    public QuizQuestionViewHolder(@NonNull View itemView) {
        super(itemView);
        questionField = itemView.findViewById(R.id.questionTextFieldInQuestionCard);


    }
    public void bind(final Question question){
        //setting id
//        int id = IdGenerator.getNewButtonId();
//        itemView.setId(id);
//        Task.setId(id);

//        course.setText(Task.getCourse());
//        level.setText(Task.getLevel());
//        teacherName.setText(Task.getTeacherName());
//        title.setText(Task.getTitle());
//        description.setText(Task.getDescription());
//        topic.setText(Task.getTopic());
//        attempt.setTag(Task.getId());
        questionField.setText(question.getQuestion());
    }
}
