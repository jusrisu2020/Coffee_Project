package com.sinhvien.coffee_mobileapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.sinhvien.coffee_mobileapp.DTO.UserDTO;
import com.sinhvien.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public int CheckLogin(String userName, String password){
        int idUser = 0;
        Database db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE USER_NAME = '"+userName+"' AND PASSWORD = '"+password+"'");
                while (resultSet.next()){
                    idUser = resultSet.getInt(1);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return idUser;
    }
}
