package com.example.isthateasy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;

public class RegisterPickerActivity extends AppCompatActivity {
    Button continueAsStudent;
    Button continueAsTeacher;
    Button continueAsHeadMaster;
    private String TAG = "RegisterPickerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_picker);
        continueAsStudent = findViewById(R.id.continueAsStudent);
        continueAsTeacher =findViewById(R.id.continueAsTeacher);
        continueAsHeadMaster = findViewById(R.id.continueAsHeadmaster);

        continueAsStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterPickerActivity.this, RegisterAsStudentActivity.class);
                startActivity(intent);


            }

        });
        continueAsTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterPickerActivity.this, RegisterAsTeacherActivity.class);
                startActivity(intent);


            }
        });
        continueAsHeadMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterPickerActivity.this, RegisterAsSchoolActivity.class);
                startActivity(intent);


            }
        });

        Button signOut = findViewById(R.id.signOut);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance()
                        .signOut(RegisterPickerActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {
                                // ...
                                Log.d(TAG, "onComplete: logout success");
                                Toast.makeText(RegisterPickerActivity.this, "logout success", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
            }
        });

    }
}