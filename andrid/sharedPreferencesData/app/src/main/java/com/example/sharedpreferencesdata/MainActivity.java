package com.example.sharedpreferencesdata;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etStudentId = findViewById(R.id.registerEtStudentId);
        EditText etName = findViewById(R.id.registerEtName);
        EditText etMajor = findViewById(R.id.registerEtMajor);

        AppCompatButton buRegister = findViewById(R.id.registerBuRegister);

        buRegister.setOnClickListener(view -> {
            String studentId = etStudentId.getText().toString().trim();
            String name = etName.getText().toString().trim();
            String major = etMajor.getText().toString().trim();

            if (!studentId.isEmpty() && !name.isEmpty() && !major.isEmpty()) {
                SharedPreferences.Editor editor = getSharedPreferences("SharedPreferences",MODE_PRIVATE).edit();

                editor.putInt("studentId", Integer.parseInt(studentId));
                editor.putString("name", name);
                editor.putString("major", major).apply();

                Intent intent = new Intent(getApplicationContext(), Show.class);
                startActivity(intent);
            }
        });
    }
}