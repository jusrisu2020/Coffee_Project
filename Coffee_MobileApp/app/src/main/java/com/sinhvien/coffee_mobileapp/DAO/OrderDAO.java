package com.sinhvien.coffee_mobileapp.DAO;

import android.database.Cursor;
import android.util.Log;

import com.sinhvien.coffee_mobileapp.DTO.DrinkDTO;
import com.sinhvien.coffee_mobileapp.DTO.OrderDTO;
import com.sinhvien.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    Database db;

    public List<OrderDTO> getOrders(){
        List<OrderDTO> listOrder = new ArrayList<OrderDTO>();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM ORDERS");
                while (resultSet.next()){
                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setId(resultSet.getInt(1));
                    orderDTO.setTableId(resultSet.getInt(2));
                    orderDTO.setStaffId(resultSet.getInt(3));
                    orderDTO.setStatus(resultSet.getInt(4));
                    orderDTO.setBookingDate(resultSet.getString(5));
                    orderDTO.setTotal(resultSet.getFloat(6));
                    listOrder.add(orderDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listOrder;
    }

    public List<OrderDTO> getOrderListByDate(String bookingDate){
        List<OrderDTO> listOrder = new ArrayList<OrderDTO>();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM ORDERS WHERE BOOKING_DATE LIKE '%"+bookingDate+"%'");
                while (resultSet.next()){
                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setId(resultSet.getInt(1));
                    orderDTO.setTableId(resultSet.getInt(2));
                    orderDTO.setStaffId(resultSet.getInt(3));
                    orderDTO.setStatus(resultSet.getInt(4));
                    orderDTO.setBookingDate(resultSet.getString(5));
                    orderDTO.setTotal(resultSet.getFloat(6));
                    listOrder.add(orderDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listOrder;
    }

    public int getOrderIdByTableId(int tableId){
        db = new Database();
        Connection conn = db.getConnect();
        int result = 0;
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM ORDERS WHERE TABLE_ID = "+tableId);
                while (resultSet.next()){
                    result = resultSet.getInt(1);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return result;
    }


}
