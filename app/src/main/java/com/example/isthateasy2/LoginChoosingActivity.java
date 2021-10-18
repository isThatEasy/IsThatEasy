package com.example.isthateasy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginChoosingActivity extends AppCompatActivity {
    Button loginButton;
    Button RegisterAsSchoolbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_chooosing);
        loginButton = findViewById(R.id.loginbtn_choosing);
        RegisterAsSchoolbtn=findViewById(R.id.RegisterAschoolbtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginChoosingActivity.this, LoginPageActivity.class);
                startActivity(intent);


            }

        });
        RegisterAsSchoolbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(LoginChoosingActivity.this, RegisterAsSchoolActivity.class);
                startActivity(intent1);


            }
        });

    }
}