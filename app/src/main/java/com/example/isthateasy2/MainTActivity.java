package com.example.isthateasy2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainTActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maint);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.account);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.AccountFragment.newInstance("p1","p2")).commit();
                        return true;
                    case R.id.help:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.HelpFragment.newInstance("p1","p2")).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
//        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.account:
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
    }
}