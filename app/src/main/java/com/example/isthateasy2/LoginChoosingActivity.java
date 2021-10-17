package com.example.isthateasy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginChoosingActivity extends AppCompatActivity {
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_chooosing);
        loginButton = findViewById(R.id.loginbtn_choosing);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginChoosingActivity.this, LoginPageActivity.class);
                startActivity(intent);

            }
        });
    }
}