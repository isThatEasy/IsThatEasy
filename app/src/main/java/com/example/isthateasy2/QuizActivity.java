package com.example.isthateasy2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isthateasy2.adapters.QuizQuestionAdapter;
import com.example.isthateasy2.models.Question;
import com.example.isthateasy2.models.Task;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    TextView titleTesting;
    RecyclerView questionContainerRecyclerView;
    ArrayList<Question> questionsList;
    Task task;
    QuizQuestionAdapter quizQuestionAdapter;
    ImageButton finishQuiz;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        View.OnClickListener finishListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                @SuppressLint("WrongConstant") Toast toast = Toast.makeText(QuizActivity.this,"clicked", 12);
                toast.show();
            }
        };

        finishQuiz = findViewById(R.id.finishQuiz);
        finishQuiz.setOnClickListener(finishListener);

        Intent prevIntent = getIntent();

        task =(Task) prevIntent.getSerializableExtra("task");
        loadData();
        titleTesting = findViewById(R.id.quizTitleTextField);

        questionContainerRecyclerView = findViewById(R.id.quizQuestionRecyclerView);

        quizQuestionAdapter = new QuizQuestionAdapter(questionsList);

        questionContainerRecyclerView.setHasFixedSize(true);
        questionContainerRecyclerView.setLayoutManager(new LinearLayoutManager(QuizActivity.this));
        questionContainerRecyclerView.setVerticalScrollBarEnabled(true);
        questionContainerRecyclerView.setAdapter(quizQuestionAdapter);

        titleTesting.setText(task.getTitle());
    }

    private void loadData() {
        if(task.getQuestions() != null){
            questionsList = task.getQuestions();
        }
        else {
            questionsList = new ArrayList<>();
        }


    }
}