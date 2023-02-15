package com.example.avg;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);
        EditText et3 = findViewById(R.id.et3);
        AppCompatButton button = findViewById(R.id.button);
        TextView tvResult = findViewById(R.id.tvResult);
        TextView tvAppreciation = findViewById(R.id.tvAppreciation);
        ImageView imageView = findViewById(R.id.imageView);

        button.setOnClickListener(view -> {
            String mark1 = et1.getText().toString().trim();
            String mark2 = et2.getText().toString().trim();
            String mark3 = et3.getText().toString().trim();

            if (!mark1.isEmpty() && !mark2.isEmpty() && !mark3.isEmpty()) {
                double result = (Integer.parseInt(mark1) + Integer.parseInt(mark2)
                        + Integer.parseInt(mark3)) / 3D;
                String strResult = String.valueOf(result);

                if (strResult.length() > 5) {
                    strResult = strResult.substring(0, 5);
                }
                tvResult.setText(strResult + "%");

                if (result >= 90 && result <= 100) {
                    tvAppreciation.setText("ممتاز");
                    imageView.setImageResource(R.drawable.a);
                } else if (result >= 80 && result < 90) {
                    tvAppreciation.setText("جيد جدا");
                    imageView.setImageResource(R.drawable.b);
                } else if (result >= 70 && result < 80) {
                    tvAppreciation.setText("جيد");
                    imageView.setImageResource(R.drawable.c);
                } else if (result >= 60 && result < 70) {
                    tvAppreciation.setText("ضعيف");
                    imageView.setImageResource(R.drawable.d);
                } else if (result < 60 && result >= 0) {
                    tvAppreciation.setText("راسب");
                    imageView.setImageResource(R.drawable.f);
                }
            }
        });
    }
}