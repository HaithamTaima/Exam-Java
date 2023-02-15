package com.abedsa.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyDatabase db;
    ArrayList<User> userArrayList;
    Button bEmail;
    EditText eEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bEmail = findViewById(R.id.buttonE);
        eEmail = findViewById(R.id.EditTextE);


        //انشئ القاعدة لو مش موجودة ولو مموجودة هات مؤشر عليها يا كبير..
        db = new MyDatabase(this);


        bEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emails = eEmail.getText().toString().trim();
                if (!emails.isEmpty()) {
                    User user = db.emailSearch(emails);
                    if (user == null){
                        openDialog();
                    }
                    else {
                            Toast.makeText(MainActivity.this, "User #" + user.getUserName(), Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(getBaseContext(), PassActivity.class);
                        intent.putExtra("email",user.getEmail());
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "ادخل ايميل", Toast.LENGTH_SHORT).show();
                }            }
        });
    }

    public void openDialog() {
        Dialogg dialogg = new Dialogg();
        dialogg.show(getSupportFragmentManager(), "dialogg");
    }
}