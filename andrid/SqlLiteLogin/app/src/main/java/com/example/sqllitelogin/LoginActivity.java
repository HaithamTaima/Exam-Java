package com.example.sqllitelogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etEmail = findViewById(R.id.loginEtdEmail);
        final EditText etPassword = findViewById(R.id.loginEtPassword);

        final Button buLogin = findViewById(R.id.loginBuLogin);
        final Button buRegisterPage = findViewById(R.id.loginBuRegister);

        buLogin.setOnClickListener(view -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            if (!email.isEmpty() && !password.isEmpty()) {
                try (DBOperations operations = new DBOperations(getApplicationContext())) {
                    User user = operations.getUser(email, password);
                    if (user != null) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("name", user.getName());
                        startActivity(intent);
                        finish();
                    } else {
                        showAlertDialog(LoginActivity.this);
                    }
                }
            }
        });

        buRegisterPage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public static void showAlertDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity)
                .setTitle("خطأ!")
                .setMessage("اسم المستخدم او كلمة المرور خاطئة")
                .setPositiveButton("موافق", (dialog, id) -> {

                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}