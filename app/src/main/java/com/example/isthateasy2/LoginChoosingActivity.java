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

public class LoginChoosingActivity extends AppCompatActivity {
    Button loginButton;
    Button RegisterAsSchoolbtn;
    private String TAG = "RegisterChoosingActivity";

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

        Button signOut = findViewById(R.id.signOut);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance()
                        .signOut(LoginChoosingActivity.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {
                                // ...
                                Log.d(TAG, "onComplete: logout success");
                                Toast.makeText(LoginChoosingActivity.this, "logout success", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
            }
        });

    }
}