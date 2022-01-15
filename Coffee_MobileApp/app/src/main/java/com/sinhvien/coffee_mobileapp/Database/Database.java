package com.sinhvien.coffee_mobileapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database{
    public Connection getConnect(){
        Connection conn = null;
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.250:3307/coffee","andro","andro");
//            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/coffee","root","");
        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }
        return conn;
    }
}
