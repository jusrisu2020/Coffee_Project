package com.sinhvien.coffee_mobileapp.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.sinhvien.coffee_mobileapp.DTO.OrderDetailDTO;
import com.sinhvien.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDetailDAO {
    Database db;

    public boolean CreateOrderDetail(OrderDetailDTO orderDetailDTO){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeQuery("insert into order_details(order_id, drink_id, number) " +
                        "values("+orderDetailDTO.getOrderId()+","+orderDetailDTO.getDrinkId()+","+orderDetailDTO.getNumber()+")");
                    return true;

            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public boolean CheckDrinkExists(int orderId, int drinkId){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM order_details WHERE drink_id = "+drinkId+" and order_id = "+orderId);
                if (resultSet.next()){
                    return true;
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public int getDrinkNumberByOrderId(int orderId, int drinkId){
        int number = 0;
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT number FROM order_details WHERE order_id = "+drinkId+" and order_id = "+orderId);
                if (resultSet.next()){
                    number = resultSet.getInt(1);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return number;
    }

    public boolean UpdateNumber(OrderDetailDTO orderDetailDTO){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeUpdate("UPDATE order_details SET number = "+orderDetailDTO.getNumber()+" where order_id = "+orderDetailDTO.getOrderId());
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }
}
