package com.sinhvien.coffee_mobileapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.sinhvien.coffee_mobileapp.DTO.UserDTO;
import com.sinhvien.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    Database db;
    public int CheckLogin(String userName, String password){
        int idUser = 0;
        db = new Database();
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

    public boolean CreateUser(UserDTO userDTO){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeUpdate("insert into users(full_name, gender, phone, date_of_birth, status, user_name, password) " + "values('"+userDTO.getFullName()+"',"+userDTO.getGender()+",'"+userDTO.getPhone()+"','"+userDTO.getDateOfBirth()+"',1,'"+userDTO.getUserName()+"','"+userDTO.getPassword()+"')");
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public List<UserDTO> getUsers(){
        List<UserDTO> listUser = new ArrayList<UserDTO>();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
                while (resultSet.next()){
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(resultSet.getInt(1));
                    userDTO.setFullName(resultSet.getString(2));
                    userDTO.setGender(resultSet.getInt(3));
                    userDTO.setPhone(resultSet.getString(4));
                    userDTO.setDateOfBirth(resultSet.getString(5));
                    userDTO.setStatus(resultSet.getInt(6));
                    listUser.add(userDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listUser;
    }
}
