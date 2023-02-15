package com.example.sqlliteempsalary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class customAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<Employee> allEmployees;

    public customAdapter(Context context, int resource, ArrayList<Employee> allEmployees) {
        super(context, resource, allEmployees);
        this.context = context;
        this.resource = resource;
        this.allEmployees = allEmployees;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View V = LayoutInflater.from(context).inflate(resource, null);

        TextView tvName = V.findViewById(R.id.tvName);
        TextView tvSalary = V.findViewById(R.id.tvSalary);
        LinearLayout linearLayout = V.findViewById(R.id.linearLayout);

        Employee employee = allEmployees.get(position);
        tvName.setText(employee.getName());
        tvSalary.setText(String.valueOf(employee.getSalary()));
        linearLayout.setBackgroundColor(context.getResources().getColor(
                employee.getSalary() < 1000 ? R.color.red : R.color.green));

        return V;
    }
}
