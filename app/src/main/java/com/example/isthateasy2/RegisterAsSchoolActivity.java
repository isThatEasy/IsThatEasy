package com.example.isthateasy2;

// Continue as Headmaster




import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterAsSchoolActivity extends AppCompatActivity {
EditText SchoolHeadmaster,SchoolEmailid,SchoolPnoneNumberId;
TextView textView12;
    Button button;
    Spinner spinner4,spinner3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_school);
        Button button = findViewById(R.id.button);


        // using custom adapter
//        String[] list = getResources().getStringArray(R.array.levels);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,list);
//        courseSpinner = findViewById(R.id.courseSpinnerR);
//        courseSpinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView12 = findViewById(R.id.textView12);
                String course = textView12.getText().toString();


                SchoolHeadmaster = findViewById(R.id.SchoolHeadmaster);
                String Headmaster =SchoolHeadmaster.getText().toString();

                SchoolEmailid = findViewById(R.id.SchoolEmailid);
                String Email = SchoolEmailid.getText().toString();

                SchoolPnoneNumberId = findViewById(R.id.SchoolPnoneNumberId);
                String PhoneNumber = SchoolPnoneNumberId.getText().toString();


                spinner3 = findViewById(R.id.spinner3);
                String levelTo = spinner3.getSelectedItem().toString();

                spinner4 = findViewById(R.id.spinner4);
                String levelFrom = spinner4.getSelectedItem().toString();

                @SuppressLint("WrongConstant") Toast toast = Toast.makeText(RegisterAsSchoolActivity.this,levelTo,5);
                toast.show();


            }
        });
    }
}