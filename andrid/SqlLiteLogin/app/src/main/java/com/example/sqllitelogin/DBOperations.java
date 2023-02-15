package com.example.sqllitelogin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DBOperations extends SQLiteOpenHelper {

    public DBOperations(Context c) {
        super(c, "DB_USER", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table User(id_ integer primary key AUTOINCREMENT, name text, email text, password text)");
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

    public void InsertUser(User user) {
        openDB();
        sql_db.execSQL("insert into User(name, email, password) values ('"
                + user.getName() + "','" + user.getEmail() + "','" + user.getPassword() + "')");
        closeDB();
    }

    public User getUser(String inputEmail, String inputPassword) {
        User user = null;
        openDB();
        try (Cursor C = sql_db.rawQuery("select * from User where email = ? and password = ?",
                new String[]{inputEmail, inputPassword})) {
            if (C.moveToFirst()) {
                int id = C.getInt(0);
                String name = C.getString(1);
                String email = C.getString(2);
                String password = C.getString(3);
                user = new User(id, name, email, password);
            }
        }
        closeDB();
        return user;
    }

    public ArrayList<String> getAllUserName() {
        ArrayList<String> allUsersName = new ArrayList<>();
        openDB();
        try (Cursor C = sql_db.rawQuery("select * from User", null)) {
            while (C.moveToNext()) {
                allUsersName.add(C.getString(1));
            }
        }
        closeDB();
        return allUsersName;
    }
}
