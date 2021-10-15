package com.example.isthateasy2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = "FirebaseLog";
    static String selectedLevel = null;
    Button btn_p1, btn_p2, btn_p3, btn_p4, btn_p5, btn_p6, btn_continue;
    int selectedButtonId, prevSelectedButtonId;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String android_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        btn_p1 = findViewById(R.id.p1);
        btn_p2 = findViewById(R.id.p2);
        btn_p3 = findViewById(R.id.p3);
        btn_p4 = findViewById(R.id.p4);
        btn_p5 = findViewById(R.id.p5);
        btn_p6 = findViewById(R.id.p6);

        btn_continue = findViewById(R.id.welcome_continue);

        String uniqueID = UUID.randomUUID().toString();

        android_id = Secure.getString(getContentResolver(), Secure.ANDROID_ID);

        View.OnClickListener lst = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevSelectedButtonId = selectedButtonId;
                selectedButtonId = view.getId();
                if (prevSelectedButtonId == selectedButtonId) {
                    return;
                }
                Button btn = findViewById(selectedButtonId);
                btn.setBackground(getDrawable(R.drawable.button_selected));


                switch (selectedButtonId) {
                    case R.id.p1:
                        selectedLevel = "P1";
                        break;
                    case R.id.p2:
                        selectedLevel = "P2";
                        break;
                    case R.id.p3:
                        selectedLevel = "P3";
                        break;
                    case R.id.p4:
                        selectedLevel = "P4";
                        break;
                    case R.id.p5:
                        selectedLevel = "P5";
                        break;
                    case R.id.p6:
                        selectedLevel = "P6";
                        break;
                    default:
                        break;


                }
                switch (prevSelectedButtonId) {
                    case R.id.p1:
                        btn_p1.setBackground(getDrawable(R.drawable.buttonpone));
                        break;
                    case R.id.p2:
                        btn_p2.setBackground(getDrawable(R.drawable.buttonptwo));
                        break;
                    case R.id.p3:
                        btn_p3.setBackground(getDrawable(R.drawable.buttonpthree));
                        break;
                    case R.id.p4:
                        btn_p4.setBackground(getDrawable(R.drawable.buttonpfour));
                        break;
                    case R.id.p5:
                        btn_p5.setBackground(getDrawable(R.drawable.buttonpfive));
                        break;
                    case R.id.p6:
                        btn_p6.setBackground(getDrawable(R.drawable.buttonpsix));
                        break;
                    default:
                        break;


                }
//                Toast.makeText(WelcomeActivity.this, "std : "+(R.id.p1 == id), Toast.LENGTH_SHORT).show();

            }
        };

        btn_p1.setOnClickListener(lst);
        btn_p2.setOnClickListener(lst);
        btn_p3.setOnClickListener(lst);
        btn_p4.setOnClickListener(lst);
        btn_p5.setOnClickListener(lst);
        btn_p6.setOnClickListener(lst);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> device = new HashMap<>();
                device.put("selectedLevel", selectedLevel);

                db.collection("devices").document(android_id)
                        .set(device)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });

            }
        });
    }
}
