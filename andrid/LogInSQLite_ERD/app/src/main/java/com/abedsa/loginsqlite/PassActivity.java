package com.abedsa.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PassActivity extends AppCompatActivity {
    Button bPass;
    EditText ePass;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        bPass = findViewById(R.id.buttonPass);
        ePass = findViewById(R.id.EditTextPass);

        //انشئ القاعدة لو مش موجودة ولو مموجودة هات مؤشر عليها يا كبير..
        db = new MyDatabase(this);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        bPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass =ePass.getText().toString().trim();

                Toast.makeText(PassActivity.this, "##"+email, Toast.LENGTH_SHORT).show();
                if (!pass.isEmpty()) {
                    User user = db.getUser(email,pass);
                    if (user == null){
                        openDialog();
                    }
                    else {
                        Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getBaseContext(), "ادخل الباسورد", Toast.LENGTH_SHORT).show();
                }

            }});
    }

    public void openDialog() {
        Dialogg dialogg = new Dialogg();
        dialogg.show(getSupportFragmentManager(), "dialogg");
    }
}