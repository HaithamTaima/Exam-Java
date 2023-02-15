package com.example.imageandhttp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    String url1 = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/800px-Image_created_with_a_mobile_phone.png";
    String url2 = "https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aHVtYW58ZW58MHx8MHx8&w=1000&q=80";
    String url3 = "https://images.unsplash.com/photo-1673906510964-780fd008924f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxjb2xsZWN0aW9uLXRodW1ibmFpbHx8M3BYOUJjaFNXV1F8fGVufDB8fHx8&auto=format&fit=crop&w=420&q=60";
    String url4 = "https://images.unsplash.com/photo-1623267255566-af9abd7adaf4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8ZGFyayUyMHRvbmV8ZW58MHx8MHx8&w=1000&q=80";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        AppCompatButton button1 = findViewById(R.id.button);
        AppCompatButton button2 = findViewById(R.id.button2);
        AppCompatButton button3 = findViewById(R.id.button3);
        AppCompatButton button4 = findViewById(R.id.button4);


        button1.setOnClickListener(v -> {
            LongOperation runningTask = new LongOperation(url1);
            runningTask.execute();
        });

        button2.setOnClickListener(v -> {
            LongOperation runningTask = new LongOperation(url2);
            runningTask.execute();
        });

        button3.setOnClickListener(v -> {
            LongOperation runningTask = new LongOperation(url3);
            runningTask.execute();
        });

        button4.setOnClickListener(v -> {
            LongOperation runningTask = new LongOperation(url4);
            runningTask.execute();
        });
    }


    @SuppressLint("StaticFieldLeak")
    private final class LongOperation extends AsyncTask<Void, Void, Bitmap> {
        private final String strURL;

        public LongOperation(String strURL) {
            this.strURL = strURL;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                URL url = new URL(strURL);
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream input = connection.getInputStream();
                return BitmapFactory.decodeStream(input);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}