package com.coffee.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coffee.coffee_mobileapp.DAO.UserDAO;
import com.coffee.coffee_mobileapp.R;
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_UserName, et_Password;
    Button btn_Login, btn_Register;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btn_Login.setOnClickListener(this);
        btn_Register.setOnClickListener(this);
    }

    void init(){
        et_UserName = findViewById(R.id.et_UserName);
        et_Password = findViewById(R.id.et_Password);
        btn_Login = findViewById(R.id.btn_Login);
        btn_Register = findViewById(R.id.btn_Register);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_Login:
                String userName = et_UserName.getText().toString();
                String password = et_Password.getText().toString();
                userDAO = new UserDAO();
                if (userDAO.CheckLogin(userName, password)){
                    Intent it = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(it);
                }else{
                    Toast.makeText(LoginActivity.this, "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_Register:
                Intent it_Register = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(it_Register);
                break;
        }
    }
}