package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.sinhvien.coffee_mobileapp.R;

public class WelcomeActivity extends AppCompatActivity {

    Button btn_WelcomLogin, btn_WelcomRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        btn_WelcomLogin = findViewById(R.id.btn_WelcomLogin);
        btn_WelcomRegister = findViewById(R.id.btn_WelcomRegister);

        btn_WelcomLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(findViewById(R.id.btn_WelcomLogin),"transition_login");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }
                else {
                    startActivity(intent);
                }
            }
        });

        btn_WelcomRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(findViewById(R.id.btn_WelcomRegister),"transition_signup");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }
                else {
                    startActivity(intent);
                }
            }
        });


    }
    //chuyển sang trang đăng nhập

    // chuyển sang trang đăng ký
//    public void callSignUpFromWel(View view)
//    {
//        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
//        Pair[] pairs = new Pair[1];
//        pairs[0] = new Pair<View, String>(findViewById(R.id.btn_signup),"transition_signup");
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this,pairs);
//            startActivity(intent,options.toBundle());
//        }
//        else {
//            startActivity(intent);
//        }
//    }
}