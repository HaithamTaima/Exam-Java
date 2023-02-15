package com.example.sqllitelogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etFullName = findViewById(R.id.registerEtFullName);
        final EditText etEmail = findViewById(R.id.registerEtEmail);
        final EditText etPassword = findViewById(R.id.registerEtPassword);

        final Button buRegister = findViewById(R.id.registerBuRegister);

        buRegister.setOnClickListener(view -> {
            String fullName = etFullName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (password.length() < 6 ){
                Toast.makeText(this, "يجب ان تحتوي كلمة المرور على 6 احرف على الاقل",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (!fullName.isEmpty() && !email.isEmpty()) {
                User user = new User(fullName, email, password);

                try (DBOperations operations = new DBOperations(getApplicationContext())) {
                    operations.InsertUser(user);

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.putExtra("name",user.getName());
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}