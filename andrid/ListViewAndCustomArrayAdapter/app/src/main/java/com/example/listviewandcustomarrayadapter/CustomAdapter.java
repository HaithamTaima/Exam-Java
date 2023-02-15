package com.example.listviewandcustomarrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class CustomAdapter extends ArrayAdapter<ModelPerson> {
    Context context;
    int resource;
    List<ModelPerson> peoples;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<ModelPerson> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.peoples = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
        }

        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvSalary = convertView.findViewById(R.id.tvNationality);

        ModelPerson person = peoples.get(position);

        tvName.setText(person.getName());
        tvSalary.setText(String.valueOf(person.getNationality()));

        return convertView;
    }
}
