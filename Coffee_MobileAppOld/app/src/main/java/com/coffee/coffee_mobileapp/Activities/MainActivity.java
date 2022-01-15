package com.coffee.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.coffee.coffee_mobileapp.R;

public class MainActivity extends AppCompatActivity {

    Button btn_LinkLogin, btn_LinkRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn_LinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(it);
            }
        });

        btn_LinkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    void init(){
        btn_LinkLogin = findViewById(R.id.btn_LinkLogin);
        btn_LinkRegister = findViewById(R.id.btn_LinkRegister);
    }
}