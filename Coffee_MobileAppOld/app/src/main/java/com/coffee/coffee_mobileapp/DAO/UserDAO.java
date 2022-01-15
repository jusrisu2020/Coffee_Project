package com.coffee.coffee_mobileapp.DAO;

import android.util.Log;


import com.coffee.coffee_mobileapp.DTO.UserDTO;
import com.coffee.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean CheckLogin(String userName, String password){
        Database db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE USER_NAME = '"+userName+"' AND PASSWORD = '"+password+"'");
                if (resultSet.next())
                    return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public List<UserDTO> getUserByEmail(String Email){
        Database DB = new Database();
        Connection conn = DB.getConnect();
        try {
            if(conn != null){
                List<UserDTO> listUser = new ArrayList<UserDTO>();
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS WHERE EMAIL = '"+Email+"'");
                while (resultSet.next()){
                    UserDTO userDTO = new UserDTO();
                    userDTO.setId(resultSet.getInt(1));
                    userDTO.setUserName(resultSet.getString(2));
                    userDTO.setPassword(resultSet.getString(4));
                    userDTO.setGender(resultSet.getInt(5));
                    listUser.add(userDTO);
                }
                return listUser;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return null;
    }
}
