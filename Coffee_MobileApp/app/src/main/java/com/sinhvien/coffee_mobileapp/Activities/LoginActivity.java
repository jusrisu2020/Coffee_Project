package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.sinhvien.coffee_mobileapp.DAO.UserDAO;
import com.sinhvien.coffee_mobileapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputLayout tipl_UserName, tipl_Password;
    ImageView imgv_Login_Back;
    Button btnLogin, btnRegister;

    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // KHỞI TẠO
        init();
        userDAO = new UserDAO();

        btnLogin.setOnClickListener(this);
        imgv_Login_Back.setOnClickListener(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(it);
            }
        });
    }

    void init(){
        tipl_UserName = findViewById(R.id.tipl_UserName);
        tipl_Password = findViewById(R.id.tipl_Password);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        imgv_Login_Back = findViewById(R.id.imgv_Login_Back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                String userName = tipl_UserName.getEditText().getText().toString();
                String password = tipl_Password.getEditText().getText().toString();
                int checkUser = userDAO.CheckLogin(userName,password);
                if(checkUser != 0){
                    //gửi dữ liệu user qua trang chủ
                    if (checkUser == 1 ){
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtra("userName",userName);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(getApplicationContext(),CustomerActivity.class);
                        intent.putExtra("userName",userName);
                        startActivity(intent);
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Đăng nhập thất bại!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.imgv_Login_Back:
                finish();
                break;
//            case R.id.btnRegister:
//                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
//                startActivity(intent);
////                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//                break;
        }
    }

    //region Validate field
//    private boolean validateUserName(){
//        String val = TXTL_login_TenDN.getEditText().getText().toString().trim();
//
//        if(val.isEmpty()){
//            TXTL_login_TenDN.setError(getResources().getString(R.string.not_empty));
//            return false;
//        }else {
//            TXTL_login_TenDN.setError(null);
//            TXTL_login_TenDN.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//    private boolean validatePassWord(){
//        String val = TXTL_login_MatKhau.getEditText().getText().toString().trim();
//
//        if(val.isEmpty()){
//            TXTL_login_MatKhau.setError(getResources().getString(R.string.not_empty));
//            return false;
//        }else{
//            TXTL_login_MatKhau.setError(null);
//            TXTL_login_MatKhau.setErrorEnabled(false);
//            return true;
//        }
//    }
    //endregion
}