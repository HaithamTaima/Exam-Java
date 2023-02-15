package com.example.sqllitelogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvName = findViewById(R.id.tvName);

        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("name"));

        try (DBOperations operations = new DBOperations(getApplicationContext())) {
            ArrayList<String> allUsers = operations.getAllUserName();

            ListView listview = findViewById(R.id.listView);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, allUsers);
            listview.setAdapter(adapter);
        }
    }
}
