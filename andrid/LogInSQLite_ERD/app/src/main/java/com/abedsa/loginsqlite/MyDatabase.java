package com.abedsa.loginsqlite;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "users_db";//اسم قاعدة البيانات
    public static final int DB_VERSION = 1;//رقم اصدار قاعدة البيانات
    //يفضل تعريف اسماء الجداول والاعمدة داخل ثوابت
    //اسماء الجداول والاعمدة
    public static final String USER_TB_NAME = "user";
    public static final String USER_CLN_ID = "id";
    public static final String USER_CLN_NAME = "name";
    public static final String USER_CLN_PASSWORD = "passWord";
    public static final String USER_CLN_ADDRESS = "address";
    public static final String USER_CLN_PHONENUMBER = "phoneNumber";
    public static final String USER_CLN_EMAIL = "email";
     SQLiteDatabase db ;

    public MyDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//يتم استدعائها عند انشاء القاعدة مرة واحدة فقط
        //اوامر الاضافة تكتب هنا

        //انشاء جدول السيارات واضافته لقاعدة البيانات
        sqLiteDatabase.execSQL("Create Table " + USER_TB_NAME + " (" + USER_CLN_ID + " integer Primary Key," +
                "" + USER_CLN_NAME + " Text ," + USER_CLN_PASSWORD + " TEXT ," + USER_CLN_ADDRESS + " TEXT," + USER_CLN_PHONENUMBER + " TEXT,"+ USER_CLN_EMAIL + " TEXT UNIQUE ) ");
        db = sqLiteDatabase;
        User u1 = new User(101,"Ali","123123","G","0599123000","ali@gmail.com");
        User u2 = new User(102,"Mohamed","101010","R","0599123000","mod@gmail.com");
        insertUser(u1,true);
        insertUser(u2,true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//يتم استدعائها عند كل تحديث للقاعدة(عند تغير الاصدار VERSION)
        //في مراحل التطوير
        //هنا ادا احتجت اضافة جدول او تعديل يجب ان اقوم بحذف الجدول القديم تم اعادة انشائه مرة اخرى بالاضافات الجديدة
        //حدف الجداول
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TB_NAME + "");
        //اعادة انشاء قاعدة البيانات
        onCreate(sqLiteDatabase);

        //اما ادا كان التطبيق نازل للمستخدمين يجب استخدام جمل التعديل (ALTER) للحفاظ على بيانات المستخدمين
    }

    public void getWritable(){
        db = getWritableDatabase();

    }
    //دالة اضافة بيانات لقاعدة البيانات
    public boolean insertUser(User user,boolean isFirstTime) {
        //مؤشر على الداتا بيز من نوع كتابةWrita
        if (!isFirstTime) {
            getWritable();
        }
        //نضع البيانات المراد تخزينها على شكل كلاسContentValues
        ContentValues values = new ContentValues();
        values.put(USER_CLN_ID, user.getId());//اسم العمود والقيمة المراد اضافتها
        values.put(USER_CLN_NAME, user.getUserName());//اسم العمود والقيمة المراد اضافتها
        values.put(USER_CLN_PASSWORD, user.getPassword());
        values.put(USER_CLN_ADDRESS, user.getAddress());
        values.put(USER_CLN_PHONENUMBER, user.getPhoneNumber());
        values.put(USER_CLN_EMAIL, user.getEmail());
        //بدل كتابة جمل كويري sql يوجد دالة(insert) لاضافة عناصر للجدول وتأخد منك اسم الحدول وقيمvalues
        long result = db.insert(USER_TB_NAME, null, values);
        //falseادا لم تتم الاضافة يرجع
        if (result == -1)
            return false;
        //true ادا ثم الاضافة يرجع
        return true;
    }


    //دالة بحث
    public User emailSearch(String email) {
        User user = null;
        SQLiteDatabase dp = getReadableDatabase();
        //  كتابة جمل كويري sql داخل دالة(rawQuery) ترجع اوبجكت
        Cursor cursor = dp.rawQuery("SELECT * FROM " + USER_TB_NAME +
                " Where " + USER_CLN_EMAIL + "=?", new String[]{email});

        if (cursor != null && cursor.moveToFirst()) {//moveToFirst  نقل المؤشر لاول عنصر(Cursor)
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(USER_CLN_ID));//getColumnIndexOrThrow بتجيب رقم العمود حسب الاسم
                String name = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_NAME));
                String pass = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_PASSWORD));
                String address = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_ADDRESS));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_PHONENUMBER));
                String emails = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_EMAIL));

                user = new User(id,name,pass,address,phone,emails);

            cursor.close();//اغلاق cursor
        }
        return user;//يرجع المصفوفة users

    }
    //دالة بحث
    public User getUser(String email,String password) {
        User user = null;
        SQLiteDatabase dp = getReadableDatabase();
        //  كتابة جمل كويري sql داخل دالة(rawQuery) ترجع اوبجكت
        Cursor cursor = dp.rawQuery("SELECT * FROM " + USER_TB_NAME +
                " Where " + USER_CLN_EMAIL + "=? and " + USER_CLN_PASSWORD + "=?", new String[]{email,password});

        if (cursor != null && cursor.moveToFirst()) {//moveToFirst  نقل المؤشر لاول عنصر(Cursor)
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(USER_CLN_ID));//getColumnIndexOrThrow بتجيب رقم العمود حسب الاسم
            String name = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_NAME));
            String pass = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_PASSWORD));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_ADDRESS));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_PHONENUMBER));
            String emails = cursor.getString(cursor.getColumnIndexOrThrow(USER_CLN_EMAIL));

            user = new User(id,name,pass,address,phone,emails);

            cursor.close();//اغلاق cursor
        }
        return user;//يرجع المصفوفة users

    }



}
