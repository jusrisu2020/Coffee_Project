package com.sinhvien.coffee_mobileapp.DAO;

import android.util.Log;

import com.sinhvien.coffee_mobileapp.DTO.CategoryDTO;
import com.sinhvien.coffee_mobileapp.DTO.DrinkDTO;
import com.sinhvien.coffee_mobileapp.DTO.TableDTO;
import com.sinhvien.coffee_mobileapp.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    Database db;

    public List<CategoryDTO> getCategories(){
        List<CategoryDTO> listCategory = new ArrayList<CategoryDTO>();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM CATEGORIES");
                while (resultSet.next()){
                    CategoryDTO categoryDTO = new CategoryDTO();
                    categoryDTO.setId(resultSet.getInt(1));
                    categoryDTO.setCategoryName(resultSet.getString(2));
                    listCategory.add(categoryDTO);
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return listCategory;
    }

    public boolean CreateCategory(CategoryDTO categoryDTO){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeUpdate("INSERT INTO CATEGORIES(category_name) " + "values('"+categoryDTO.getCategoryName()+"')");
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public boolean EditCategory(CategoryDTO categoryDTO, int categoryId){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeUpdate("UPDATE CATEGORIES SET CATEGORY_NAME = '"+categoryDTO.getCategoryName()+"' WHERE ID = "+categoryId);
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }

    public CategoryDTO getCategoryById(int id){
        CategoryDTO categoryDTO = new CategoryDTO();
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM CATEGORIES WHERE ID = " + id);
                while (resultSet.next()){
                    categoryDTO.setId(resultSet.getInt(1));
                    categoryDTO.setCategoryName(resultSet.getString(2));
                }
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return categoryDTO;
    }

    public boolean DeleteCategory(int categoryId){
        db = new Database();
        Connection conn = db.getConnect();
        try {
            if(conn != null){
                Statement statement = conn.createStatement();
                statement.executeUpdate("DELETE FROM CATEGORIES WHERE ID = "+categoryId);
                return true;
            }
        }catch (Exception e){
            Log.e("Error",e.getMessage());
        }
        return false;
    }
}
