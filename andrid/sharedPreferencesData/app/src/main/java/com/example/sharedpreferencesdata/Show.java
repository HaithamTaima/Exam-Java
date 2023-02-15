package com.example.sharedpreferencesdata;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Show extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        SharedPreferences preferences = getSharedPreferences("SharedPreferences",MODE_PRIVATE);

        String name = preferences.getString("name", "name");
        String major = preferences.getString("major", "major");

        TextView tvMassage = findViewById(R.id.tvMassage);

        tvMassage.setText("Hi " + name + " in " + major);
    }
}