package com.example.imageview;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Void> takePictureLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton button = findViewById(R.id.button);
        ImageView imageView = findViewById(R.id.imageView);

        takePictureLauncher = registerForActivityResult(
                new ActivityResultContracts.TakePicturePreview(), result -> {
                    if (result != null) {
                        imageView.setImageBitmap(result);
                    }
                });

        button.setOnClickListener(view -> {
            takePictureLauncher.launch(null);
        });
    }
}