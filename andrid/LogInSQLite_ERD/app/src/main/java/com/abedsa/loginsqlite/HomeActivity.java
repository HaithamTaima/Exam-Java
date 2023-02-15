package com.abedsa.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView ID,Name,PassWord,Address,Phone,Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ID = findViewById(R.id.textViewID);
        Name = findViewById(R.id.textViewName);
        PassWord = findViewById(R.id.textViewPassWord);
        Address = findViewById(R.id.textViewAddress);
        Phone = findViewById(R.id.textViewPhone);
        Email = findViewById(R.id.textViewEmail);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");

        ID.setText(String.valueOf(user.getId()));
        Name.setText(user.getUserName());
        PassWord.setText(user.getPassword());
        Address.setText(user.getAddress());
        Phone.setText(user.getPhoneNumber());
        Email.setText(user.getEmail());



    }
}