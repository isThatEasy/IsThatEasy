package com.example.isthateasy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
//        bottomNavigationView.setSelectedItemId(R.id.meMenuItem);
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.HomeFragment.newInstance("p1","p2")).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.meMenuItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.AccountFragment.newInstance("p1","p2")).commit();
                        return true;
                    case R.id.searchMenuItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.SearchFragment.newInstance("p1","p2")).commit();
                        return true;
                    case R.id.ClassesMenuItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.ClassesFragment.newInstance("p1","p2")).commit();
                        return true;
                    case R.id.savedMenuItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.SavedFragment.newInstance("p1","p2")).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}