package com.example.isthateasy2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.isthateasy2.R;
import com.example.isthateasy2.models.Contact;
import com.example.isthateasy2.models.Question;
import com.example.isthateasy2.models.Task;

import java.util.List;

public class QuizQuestionAdapter extends RecyclerView.Adapter<QuizQuestionViewHolder> {
    private static final int VIEW_TYPE_FOOTER = 1;
    private static final int VIEW_TYPE_CELL = 2;
    List<Question> questions;
    QuizQuestionViewHolder quizQuestionViewHolder;
//    Button attempt;
//    public static View.OnClickListener selectingTaskListener;

//    public void setListener(View.OnClickListener listener){
//        selectingTaskListener = listener;
//    }

    public QuizQuestionAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public int getItemViewType(int position) {
        // this will help to add view at the end of default value
        // full reference see at footer comment [1]
        return (position == questions.size()) ? VIEW_TYPE_FOOTER : VIEW_TYPE_CELL;
    }

    @NonNull
    @Override
    public QuizQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_CELL){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_quiz_multiple_choice_card,parent,false);

//        view.setOnClickListener(selectingTaskListener);
//        attempt = view.findViewById(R.id.class_Enter);
//        attempt.setOnClickListener(selectingTaskListener);
            return new QuizQuestionViewHolder(view);
        }
        else {
            Button button = new Button(parent.getContext());
            button.setText("Finish now");
            return new QuizQuestionViewHolder(button);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull QuizQuestionViewHolder holder, int position) {
        // to avoid null reference of questions arraylist because value we add to the getItemCout() function
        // reference [1] #check in footer comment


        if (position != questions.size()) {
            final Question question = questions.get(position);
            holder.bind(question);
        }
        quizQuestionViewHolder = holder;

    }

    @Override
    public int getItemCount() {
        return questions.size() + 1;
    }
}
/*
[1] https://stackoverflow.com/questions/29106484/how-to-add-a-button-at-the-end-of-recyclerview/38691600


 */