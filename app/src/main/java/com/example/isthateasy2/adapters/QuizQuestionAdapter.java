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

    @NonNull
    @Override
    public QuizQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_quiz_multiple_choice_card,parent,false);

//        view.setOnClickListener(selectingTaskListener);
//        attempt = view.findViewById(R.id.class_Enter);
//        attempt.setOnClickListener(selectingTaskListener);
        return new QuizQuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizQuestionViewHolder holder, int position) {
        final Question question=questions.get(position);
        holder.bind(question);
        quizQuestionViewHolder=holder;
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
}
