package com.example.listviewandcustomarrayadapter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<ModelPerson> peoples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edName = findViewById(R.id.edName);
        final EditText edNationality = findViewById(R.id.edNationality);
        final Button buAdd = findViewById(R.id.buAdd);
        final ListView myListView = findViewById(R.id.listView);

        peoples = new ArrayList<>();

        buAdd.setOnClickListener(view -> {
            String name = edName.getText().toString().trim();
            String nationality = edNationality.getText().toString().trim();
            if (!name.isEmpty() && !nationality.isEmpty()) {
                peoples.add(new ModelPerson(name, nationality));
                CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.item, peoples);
                myListView.setAdapter(adapter);
            }
        });
    }
}