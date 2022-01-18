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
                    drinkDTO.setCategoryId(resultSet.getInt(2));
                    drinkDTO.setDrinkName(resultSet.getString(3));
                    drinkDTO.setStatus(resultSet.getInt(4));
                    drinkDTO.setPrice(resultSet.getFloat(5));
                    listDrink.add(drinkDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listDrink;
    }

    public DrinkDTO getDrinkById(int id){
        DrinkDTO drinkDTO = new DrinkDTO();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM DRINKS WHERE ID = " + id);
                while (resultSet.next()){
                    drinkDTO.setId(resultSet.getInt(1));
                    drinkDTO.setCategoryId(resultSet.getInt(2));
                    drinkDTO.setDrinkName(resultSet.getString(3));
                    drinkDTO.setStatus(resultSet.getInt(4));
                    drinkDTO.setPrice(resultSet.getFloat(5));
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return drinkDTO;
    }

    public List<DrinkDTO> getDrinkListByCaterogyId(int categoryId){
        List<DrinkDTO> listDrink = new ArrayList<DrinkDTO>();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM DRINKS WHERE CATEGORY_ID = " + categoryId);
                while (resultSet.next()){
                    DrinkDTO drinkDTO = new DrinkDTO();
                    drinkDTO.setId(resultSet.getInt(1));
                    drinkDTO.setCategoryId(resultSet.getInt(2));
                    drinkDTO.setDrinkName(resultSet.getString(3));
                    drinkDTO.setStatus(resultSet.getInt(4));
                    drinkDTO.setPrice(resultSet.getFloat(5));
                    listDrink.add(drinkDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listDrink;
    }


    public boolean CreateDrink(DrinkDTO drinkDTO){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                String query = "INSERT INTO DRINKS(category_id, drink_name, price) " +
                        "values("+drinkDTO.getCategoryId()+",'"+drinkDTO.getDrinkName()+"',"+drinkDTO.getPrice()+")";
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public boolean EditDrink(DrinkDTO drinkDTO, int drinkId){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                String query = "UPDATE DRINKS SET category_id = "+drinkDTO.getCategoryId()+",drink_name = '"+drinkDTO.getDrinkName()+"',status = "+drinkDTO.getStatus()+", image = '"+drinkDTO.getImage()+"', price = "+drinkDTO.getPrice()+"  WHERE ID = "+drinkId;
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }


    public boolean DeleteDrink(int drinkId){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                String query = "DELETE FROM DRINKS WHERE ID = "+drinkId;
                Statement statement = conn.createStatement();
                statement.executeUpdate(query);
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

}
