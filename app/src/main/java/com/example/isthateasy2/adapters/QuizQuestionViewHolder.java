package com.example.isthateasy2.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Question;
import com.example.isthateasy2.models.Task;
import com.example.isthateasy2.states.IdGenerator;

import java.util.ArrayList;

public class QuizQuestionViewHolder extends RecyclerView.ViewHolder {
    LinearLayout answersLinearLayout;
    TextView questionField;

    public QuizQuestionViewHolder(@NonNull View itemView) {
        super(itemView);
        questionField = itemView.findViewById(R.id.questionTextFieldInQuestionCard);
        answersLinearLayout = itemView.findViewById(R.id.chooosingAnswerLinearLayout);



    }
    @SuppressLint("ResourceType")
    public void bind(final Question question){

        switch (question.getWayOfAnswering()){
            case "multipleChoice":
                ArrayList<String> options = question.getOptions();

                CheckBox radioButton;
                for(int i = 0; i < options.size(); i++){
                    radioButton = new CheckBox(answersLinearLayout.getContext());
                    radioButton.setId(IdGenerator.getNewButtonId());
                    radioButton.setText(options.get(i));
                    Log.d("msgOption", options.get(i));

                    answersLinearLayout.addView(radioButton);
                }
        }
        questionField.setText(question.getQuestion());
    }
}
