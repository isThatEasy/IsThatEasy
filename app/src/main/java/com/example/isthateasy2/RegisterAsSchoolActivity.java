package com.example.isthateasy2;

// Continue as Headmaster




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.isthateasy2.models.School;
import com.example.isthateasy2.models.SchoolOwnerUser;
import com.example.isthateasy2.models.User;
import com.example.isthateasy2.states.S;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;

public class RegisterAsSchoolActivity extends AppCompatActivity {
    private String TAG = "RegisterAsSchool";


EditText schoolHeadmaster, schoolEmailid, schoolPnoneNumberId, schoolLocation, schoolName;
    FirebaseUser user = S.getUser();
    Button registerNowButton;
    Spinner lowerLevelSpinner, higherLevelSpinner;


    RadioButton primaryB;
    RadioButton secondaryB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_school);
        registerNowButton = findViewById(R.id.registerNowButton);


        TextView userName = findViewById(R.id.userName);
        userName.setText(user.getDisplayName());



        // using custom adapter
//        String[] list = getResources().getStringArray(R.array.levels);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,list);
//        courseSpinner = findViewById(R.id.courseSpinnerR);
//        courseSpinner.setAdapter(adapter);

        registerNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                School school = new School();

                schoolName = findViewById(R.id.SchoolName);
                school.setName(schoolName.getText().toString());

                schoolLocation = findViewById(R.id.schoolLocation);
                school.setLocation(schoolLocation.getText().toString());


                schoolEmailid = findViewById(R.id.SchoolEmailid);
                school.setContactEmail(schoolEmailid.getText().toString());

                schoolPnoneNumberId = findViewById(R.id.SchoolPnoneNumberId);
                school.setTelephone(schoolPnoneNumberId.getText().toString());


                higherLevelSpinner = findViewById(R.id.higherLevel);
                lowerLevelSpinner = findViewById(R.id.lowerLevel);
                school.createLevels(lowerLevelSpinner.getSelectedItem().toString(), higherLevelSpinner.getSelectedItem().toString());

                schoolHeadmaster = findViewById(R.id.headmasterName);
                school.setHeadMaster(schoolHeadmaster.getText().toString());



                User userInfo = new SchoolOwnerUser(user.getUid(),school);
                S.setUserInfo(userInfo);
                saveToFirebase(school);



            }
        });
    }

    private void saveToFirebase(School school) {
        S.getDb().collection("schools")
                .add(school)
               .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                   @Override
                   public void onComplete(@NonNull Task<DocumentReference> task) {
                       Toast.makeText(RegisterAsSchoolActivity.this, "successfully saved", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(RegisterAsSchoolActivity.this, HomeActivity.class);
                       startActivity(intent);
                   }
               })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterAsSchoolActivity.this, "fail to save", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}