package com.example.isthateasy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AddTaskActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button closePopupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        bottomNavigationView = findViewById(R.id.bottomNavigationViewForAddTask);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.settingMenuItem:
                        return true;
                    case R.id.addMenuItem:
                        //reference from https://android--code.blogspot.com/2016/01/android-popup-window-example.html


                        LayoutInflater inflater = (LayoutInflater) AddTaskActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupView = inflater.inflate(R.layout.add_task_popup, null);
                        PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

                                popupWindow.showAsDropDown(popupView, 0, 0);
                                popupWindow.setFocusable(true);
                                closePopupBtn = (Button) popupView.findViewById(R.id.closePopupBtn);

                                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        popupWindow.dismiss();
                                    }
                                });

                        return true;
                    case R.id.FinishMenuItem:

                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}