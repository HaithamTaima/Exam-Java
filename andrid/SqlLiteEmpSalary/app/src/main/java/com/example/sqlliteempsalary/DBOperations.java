package com.example.sqlliteempsalary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBOperations extends SQLiteOpenHelper {

    public DBOperations(Context c) {
        super(c, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Employee(_id integer primary key, Name text, salary integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    SQLiteDatabase sql_db;

    public void openDB() {
        sql_db = getWritableDatabase();
    }

    public void closeDB() {
        sql_db.close();
    }

    public void InsertContact(Employee employee) {
        openDB();
        sql_db.execSQL("insert into Employee(Name, salary) values ('" + employee.getName() + "','" + employee.getSalary() + "')");
        closeDB();
    }

    public ArrayList<Employee> selectAllEmployee(String sql, String[] args) {
        ArrayList<Employee> allEmployees = new ArrayList<>();
        openDB();
        try (Cursor C = sql_db.rawQuery(sql, args)) {
            while (C.moveToNext()) {
                int id = C.getInt(0);
                String name = C.getString(1);
                int salary = C.getInt(2);
                allEmployees.add(new Employee(id, name, salary));
            }
        }
        closeDB();
        return allEmployees;
    }
}
