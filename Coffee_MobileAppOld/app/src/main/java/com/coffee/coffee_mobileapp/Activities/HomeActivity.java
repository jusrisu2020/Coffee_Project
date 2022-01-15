package com.coffee.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.coffee.coffee_mobileapp.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout rl_Statistical, rl_Table, rl_Menu, rl_Employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        rl_Statistical.setOnClickListener(this);
    }

    void init(){
        rl_Statistical = findViewById(R.id.rl_Statistical);
        rl_Table = findViewById(R.id.rl_Table);
        rl_Menu = findViewById(R.id.rl_Menu);
        rl_Employee = findViewById(R.id.rl_Employee);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.rl_Statistical:
                finish();
                break;
            case R.id.rl_Table:
//                Intent it_Statistical = new Intent(HomeActivity.this, Statistical.class);
////                startActivity(it_Statistical);
                Toast.makeText(HomeActivity.this, "Table", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}