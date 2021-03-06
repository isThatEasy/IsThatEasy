package com.example.isthateasy2.adapters;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.C;
import com.example.isthateasy2.models.Question;
import com.example.isthateasy2.models.SelectionQuestion;
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
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("ResourceType")
    public void bind(final Question question){

        switch (question.getWayOfAnswering()){
            case C.SELECTION_WAY_OF_ANSWERING:
                ArrayList<String> options = new ArrayList<>();
                ((SelectionQuestion)question).getAnswerObject().forEach(each -> {
                    options.add(each.getAnswer());
                });
                int id = IdGenerator.getQuestionId();
                itemView.setId(id);
                question.setId(id);

                CheckBox radioButton;
                for(int i = 0; i < options.size(); i++){
                    radioButton = new CheckBox(answersLinearLayout.getContext());
                    radioButton.setId(IdGenerator.getNewClassId());
                    radioButton.setText(options.get(i));
                    Log.d("msgOption", options.get(i));

                    answersLinearLayout.addView(radioButton);
                }
        }
        questionField.setText(question.getQuestion());
    }
}
