package com.sinhvien.coffee_mobileapp.DAO;

import android.util.Log;

import com.sinhvien.coffee_mobileapp.DTO.TableDTO;
import com.sinhvien.coffee_mobileapp.DTO.UserDTO;
import com.sinhvien.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableDAO {
    Database db;

    public List<TableDTO> getTables(){
        List<TableDTO> listTable = new ArrayList<TableDTO>();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM TABLES");
                while (resultSet.next()){
                    TableDTO tableDTO = new TableDTO();
                    tableDTO.setId(resultSet.getInt(1));
                    tableDTO.setTableName(resultSet.getString(2));
                    tableDTO.setStatus(resultSet.getInt(3));
                    listTable.add(tableDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listTable;
    }

    public boolean CreateTable(String tableName){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT INTO TABLES(table_name) " + "values('"+tableName+"')");
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public boolean EditTable(String tableName, int tableId){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeUpdate("UPDATE TABLES SET TABLE_NAME = '"+tableName+"' WHERE ID = " + tableId);

                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public boolean DeleteTable(int tableId){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeUpdate("DELETE FROM TABLES WHERE ID = " + tableId);

                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }


    public String getTableNameById(int tableId){
        String tableName = "";
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM TABLES WHERE ID = "+ tableId);
                if (resultSet.next()){
                    tableName = resultSet.getString(2);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return tableName;
    }


}
