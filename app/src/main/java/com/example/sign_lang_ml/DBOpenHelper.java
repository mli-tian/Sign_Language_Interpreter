package com.example.sign_lang_ml;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    //数据库名字
    private static final String DB_NAME = "User.db";
    //创建用户表
    private static final String CREATE_USER = "create table user(id integer primary key autoincrement," +
            "username varchar(30)," +
            "password varchar(30)," +
            "signature varchar(30),"+
            "identity  varchar(30),"+
            "phone  varchar(30),"+
            "age varchar(30))";

    //运行程序时，Android Studio帮你创建数据库，只会执行一次
    public DBOpenHelper(@Nullable Context context) {
        super(context,DB_NAME,null,1);
    }

    //创建数据表
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public long register(User u){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username ",u.getUsername());
        cv.put("password",u.getPassword());
        cv.put("identity",u.getIdentity());
        cv.put("phone",u.getPhone());
        cv.put("signature",u.getSignature());
        cv.put("age",u.getAge());
        long users;
        users = db.insert("user",null,cv);
        return users;
    }

    //登录方法实现
    public boolean login(String username,String password){
        SQLiteDatabase db = getWritableDatabase();
        boolean result = false;
        @SuppressLint("Recycle") Cursor users = db.query("user", null, "username like?", new String[]{username}, null, null, null);
        if(users!=null){
            while (users.moveToNext()){
                @SuppressLint("Range") String username1 = users.getString(users.getColumnIndex("username"));
                Log.i("users", "login: "+username1);
                String password1 = users.getString(2);
                Log.i("users", "login: "+password1);
                result = password1.equals(password);
                return result;
            }
        }
        return false;
    }

    //根据用户名查找当前登录用户信息
    public User select(String Username){
        SQLiteDatabase db = getWritableDatabase();
        User SelectUser = new User();
        Cursor user = db.query("user", new String[]{"username", "password", "identity","signature","age","phone"}, "username=?", new String[]{Username}, null, null, null);
        while(user.moveToNext()){
            @SuppressLint("Range") String username =user.getString(user.getColumnIndex("username"));
            @SuppressLint("Range") String password = user.getString(user.getColumnIndex("password"));
            @SuppressLint("Range") String identity = user.getString(user.getColumnIndex("identity"));
            @SuppressLint("Range") String signature = user.getString(user.getColumnIndex("signature"));
            @SuppressLint("Range") String phone = user.getString(user.getColumnIndex("phone"));
            @SuppressLint("Range") String age = user.getString(user.getColumnIndex("age"));
            SelectUser.setSignature(signature);
            SelectUser.setPhone(phone);
            SelectUser.setAge(age);
            SelectUser.setUsername(username);
            SelectUser.setPassword(password);
            SelectUser.setIdentity(identity);
        }
        user.close();
        return SelectUser;
    }
    //修改信息
    public User modifyusername(String M_username,String Username) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", M_username);
        db.update("user", values, "username=?", new String[]{Username});
        User User = select(M_username);
        return User;

    }

    //修改信息
    public User modifysignature(String signature,String Username) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("signature", signature);
        db.update("user", values, "username=?", new String[]{Username});
        User User = select(Username);
        return User;
    }

    //修改信息
    public User modifyidentity(String identity,String Username) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("identity", identity);
        db.update("user", values, "username=?", new String[]{Username});
        User User = select(Username);
        return User;
    }

    public int modifypwd(String password,String Username) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password", password);
        int r1=db.update("user", values, "username=?", new String[]{Username});
        return r1;

    }

}

