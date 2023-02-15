package com.example.asynktaskhttpviewpager;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asynktaskhttpviewpager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getWindow().setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN);
        setContentView(binding.getRoot());

        List<String> urlList = new ArrayList<>();
        urlList.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/800px-Image_created_with_a_mobile_phone.png");
        urlList.add("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8aHVtYW58ZW58MHx8MHx8&w=1000&q=80");
        urlList.add("https://images.unsplash.com/photo-1673906510964-780fd008924f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxjb2xsZWN0aW9uLXRodW1ibmFpbHx8M3BYOUJjaFNXV1F8fGVufDB8fHx8&auto=format&fit=crop&w=420&q=60");
        urlList.add("https://images.unsplash.com/photo-1623267255566-af9abd7adaf4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8ZGFyayUyMHRvbmV8ZW58MHx8MHx8&w=1000&q=80");

        MyPagerAdapter adapter = new MyPagerAdapter(urlList, MainActivity.this);
        binding.myViewPager.setAdapter(adapter);
    }
}