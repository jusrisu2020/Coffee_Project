package com.sinhvien.coffee_mobileapp.DAO;

import android.database.Cursor;
import android.util.Log;

import com.sinhvien.coffee_mobileapp.DTO.DrinkDTO;
import com.sinhvien.coffee_mobileapp.DTO.OrderDTO;
import com.sinhvien.coffee_mobileapp.DTO.PaymentDTO;
import com.sinhvien.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    Database db;
    public List<PaymentDTO> getDrinkByOrderId(int orderId){
        List<PaymentDTO> listPayment = new ArrayList<PaymentDTO>();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT drink_name, number, price FROM order_details as od, drinks as d where order_id = "+orderId+" and d.id = od.drink_id;");
                while (resultSet.next()){
                    PaymentDTO paymentDTO = new PaymentDTO();
                    paymentDTO.setDrinkName(resultSet.getString(1));
                    paymentDTO.setNumber(resultSet.getInt(2));
                    paymentDTO.setPrice(resultSet.getFloat(3));
                    listPayment.add(paymentDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listPayment;
    }
}
