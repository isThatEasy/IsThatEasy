package com.example.isthateasy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.isthateasy2.models.Task;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent prevIntent = getIntent();

        Task task =(Task) prevIntent.getSerializableExtra("task");

        TextView titleTesting = findViewById(R.id.quizTitleTextField);

        titleTesting.setText(task.getTitle());
    }
}