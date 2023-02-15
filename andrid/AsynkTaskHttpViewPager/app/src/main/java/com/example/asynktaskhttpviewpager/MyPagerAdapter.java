package com.example.asynktaskhttpviewpager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.asynktaskhttpviewpager.databinding.ItemBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    List<String> urlList;
    Activity activity;

    public MyPagerAdapter(List<String> urlList, Activity activity) {
        this.urlList = urlList;
        this.activity = activity;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(container.getContext()),
                container, false);

        String url = urlList.get(position);

        getBitmapFromUrl(url, imageBitmap -> {
            if (imageBitmap != null) {
                activity.runOnUiThread(() -> binding.myImageView.setImageBitmap(imageBitmap));
            }
        });

        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    }

    @Override
    public int getCount() {
        return urlList.size();
    }

    private interface LoadImageListener {
        void onLoadImageListener(Bitmap imageBitmap);
    }

    private static void getBitmapFromUrl(String strURL, LoadImageListener listener) {
        new Thread(() -> {
            try {
                URL url = new URL(strURL);
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                listener.onLoadImageListener(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
                listener.onLoadImageListener(null);
            }
        }).start();
    }
}
