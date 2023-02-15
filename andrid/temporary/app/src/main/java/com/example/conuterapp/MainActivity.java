package com.example.conuterapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    int num = 1;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tvNumber = findViewById(R.id.tvNumber);
        TextView tvNumProgress = findViewById(R.id.tvNumProgress);

        Button buMinus = findViewById(R.id.buMinus);
        Button buPlus = findViewById(R.id.buPlus);

        Button buStartCountDown = findViewById(R.id.buStartCountDown);

        ProgressBar progressBar = findViewById(R.id.progressBar);

        buMinus.setOnClickListener(v -> {
            if (num > 1) {
                num--;
                tvNumber.setText(String.valueOf(num));
            }
        });

        buPlus.setOnClickListener(v -> {
            num++;
            tvNumber.setText(String.valueOf(num));
        });

        buStartCountDown.setOnClickListener(v -> {
            if (!isRunning) {
                isRunning = true;
                progressBar.setMax(num);
                new Thread(() -> {
                    int numLoop = num;
                    for (int i = -1; i < numLoop; i++) {
                        runOnUiThread(() -> {
                            tvNumProgress.setText(String.valueOf(num));
                            progressBar.setProgress(num);
                        });
                        SystemClock.sleep(1000);
                        num--;
                    }
                    isRunning = false;
                    runOnUiThread(() -> {
                        Toast.makeText(this, "انتهى الوقت", Toast.LENGTH_SHORT).show();
                    });
                    finish();
                }).start();
            }
        });
    }
}