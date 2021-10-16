package com.example.isthateasy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.isthateasy2.adapters.ContactAdapter;
import com.example.isthateasy2.models.Contact;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    FloatingActionButton homeMenuItem;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeMenuItem = findViewById(R.id.homeMenuItem);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setSelectedItemId(R.id.holderMenuItem);
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.HomeFragment.newInstance("p1", "p2")).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.meMenuItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.AccountFragment.newInstance("p1", "p2")).commit();
                        return true;
                    case R.id.searchMenuItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.SearchFragment.newInstance("p1", "p2")).commit();
                        return true;
                    case R.id.ClassesMenuItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.ClassesFragment.newInstance("p1", "p2")).commit();
                        return true;
                    case R.id.savedMenuItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.SavedFragment.newInstance("p1", "p2")).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });

        homeMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, com.example.isthateasy2.HomeFragment.newInstance("p1", "p2")).commit();
                bottomNavigationView.setSelectedItemId(R.id.holderMenuItem);

            }
        });
    }

}