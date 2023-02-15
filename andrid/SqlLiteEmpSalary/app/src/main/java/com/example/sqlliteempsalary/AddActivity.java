package com.example.sqlliteempsalary;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    String sql = "select * from Employee";
    String[] args = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        final EditText edName = findViewById(R.id.edName);
        final EditText edSalary = findViewById(R.id.edSalary);

        final Button buInsert = findViewById(R.id.buInsert);

        getDataAndSetListView();

        buInsert.setOnClickListener(view -> {
            String name = edName.getText().toString().trim();
            String salary = edSalary.getText().toString().trim();
            if (!name.isEmpty() && !salary.isEmpty()) {
                Employee employee = new Employee(name, Integer.parseInt(salary));

                try (DBOperations operations = new DBOperations(AddActivity.this)) {
                    operations.InsertContact(employee);
                    getDataAndSetListView();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.buAll) {
                sql = "select * from Employee";
                args = null;
            } else if (checkedId == R.id.buMore1000) {
                sql = "select * from Employee where salary >= ? ";
                args = new String[]{"1000"};
            } else if (checkedId == R.id.buLess1000) {
                sql = "select * from Employee where salary < ? ";
                args = new String[]{"1000"};
            }
            getDataAndSetListView();
        });
    }

    void getDataAndSetListView() {
        try (DBOperations operations = new DBOperations(AddActivity.this)) {
            ArrayList<Employee> allEmployees = operations.selectAllEmployee(sql, args);

            customAdapter adapter = new customAdapter(AddActivity.this, R.layout.item, allEmployees);
            ListView myListView = findViewById(R.id.listView);
            myListView.setAdapter(adapter);
        }
    }
}
