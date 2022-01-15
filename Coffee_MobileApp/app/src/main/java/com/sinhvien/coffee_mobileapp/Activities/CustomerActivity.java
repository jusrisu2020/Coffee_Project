package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.sinhvien.coffee_mobileapp.R;

public class CustomerActivity extends AppCompatActivity {

    TextView tv_MenuUserNameCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_customer_layout);

        tv_MenuUserNameCustomer = findViewById(R.id.tv_MenuUserNameCustomer);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        tv_MenuUserNameCustomer.setText( "Xin chào " + userName +" !!");
    }
}