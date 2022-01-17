package com.sinhvien.coffee_mobileapp.DAO;

import android.util.Log;

import com.sinhvien.coffee_mobileapp.DTO.CategoryDTO;
import com.sinhvien.coffee_mobileapp.DTO.DrinkDTO;
import com.sinhvien.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DrinkDAO {
    Database db;

    public List<DrinkDTO> getDrinks(){
        List<DrinkDTO> listDrink = new ArrayList<DrinkDTO>();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM DRINKS");
                while (resultSet.next()){
                    DrinkDTO drinkDTO = new DrinkDTO();
                    drinkDTO.setId(resultSet.getInt(1));
                    drinkDTO.setDrinkName(resultSet.getString(2));
                    listDrink.add(drinkDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listDrink;
    }
}
