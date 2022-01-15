package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

import static com.sinhvien.coffee_mobileapp.R.*;

public class RegisterActivity extends AppCompatActivity {

    ImageView imgv_Login_Back;
    Button btnRegisterNext;
    TextInputLayout tipl_FullName, tipl_RegisterPhone, tipl_RegisterUserName, tipl_RegisterPassword, tipl_RegisterRePassword;
    public static final String DataRegisterUserBundel = "DataRegisterUserBundel";
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{6,}" +                // at least 4 characters
                    "$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.register_layout);

        //region lấy đối tượng view
        imgv_Login_Back = (ImageView)findViewById(id.imgv_Login_Back);
        btnRegisterNext = (Button)findViewById(id.btnRegisterNext);
        tipl_FullName = (TextInputLayout)findViewById(id.tipl_FullName);
        tipl_RegisterPhone = (TextInputLayout)findViewById(id.tipl_RegisterPhone);
        tipl_RegisterUserName = (TextInputLayout)findViewById(id.tipl_RegisterUserName);
        tipl_RegisterPassword = (TextInputLayout)findViewById(id.tipl_RegisterPassword);
        tipl_RegisterRePassword = (TextInputLayout)findViewById(id.tipl_RegisterRePassword);
        //endregion

        btnRegisterNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kiểm tra validate false => phải thỏa đk validate
//                if(!validateFullName() | !validateUserName() | !validateEmail() | !validatePhone() | !validatePassWord()){
//                    return;
//                }
                String fullName = tipl_FullName.getEditText().getText().toString();
                String phone = tipl_RegisterPhone.getEditText().getText().toString();
                String userName = tipl_RegisterUserName.getEditText().getText().toString();
                String password = tipl_RegisterPassword.getEditText().getText().toString();
                String rePassword = tipl_RegisterRePassword.getEditText().getText().toString();

                byBundleNextSignupScreen(fullName,phone,userName,password);
            }
        });
    }

    //Hàm quay về màn hình trước
    public void backFromRegister(View view){
        Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(id.layoutRegister),"transition_signup");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RegisterActivity.this,pairs);
            startActivity(intent,options.toBundle());
        }else {
            startActivity(intent);
        }
    }

    //truyền dữ liệu qua trang đk thứ 2 bằng bundle
    public void byBundleNextSignupScreen(String fullName, String phone, String userName, String password){

        Intent intent = new Intent(getApplicationContext(), Register2ndActivity.class);
        Bundle bundleData = new Bundle();
        bundleData.putString("fullName",fullName);
        bundleData.putString("phone",phone);
        bundleData.putString("userName",userName);
        bundleData.putString("password",password);
        intent.putExtra(DataRegisterUserBundel,bundleData);
        startActivity(intent);
        overridePendingTransition(anim.slide_in_right, anim.slide_out_left);
    }

    //region Validate field
//    private boolean validateFullName(){
//        String val = TXTL_signup_HoVaTen.getEditText().getText().toString().trim();
//
//        if(val.isEmpty()){
//            TXTL_signup_HoVaTen.setError(getResources().getString(string.not_empty));
//            return false;
//        }else {
//            TXTL_signup_HoVaTen.setError(null);
//            TXTL_signup_HoVaTen.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//    private boolean validateUserName(){
//        String val = TXTL_signup_TenDN.getEditText().getText().toString().trim();
//        String checkspaces = "\\A\\w{1,50}\\z";
//
//        if(val.isEmpty()){
//            TXTL_signup_TenDN.setError(getResources().getString(string.not_empty));
//            return false;
//        }else if(val.length()>50){
//            TXTL_signup_TenDN.setError("Phải nhỏ hơn 50 ký tự");
//            return false;
//        }else if(!val.matches(checkspaces)){
//            TXTL_signup_TenDN.setError("Không được cách chữ!");
//            return false;
//        }
//        else {
//            TXTL_signup_TenDN.setError(null);
//            TXTL_signup_TenDN.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//    private boolean validateEmail(){
//        String val = TXTL_signup_Email.getEditText().getText().toString().trim();
//        String checkspaces = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
//
//        if(val.isEmpty()){
//            TXTL_signup_Email.setError(getResources().getString(string.not_empty));
//            return false;
//        }else if(!val.matches(checkspaces)){
//            TXTL_signup_Email.setError("Email không hợp lệ!");
//            return false;
//        }
//        else {
//            TXTL_signup_Email.setError(null);
//            TXTL_signup_Email.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//    private boolean validatePhone(){
//        String val = TXTL_signup_SDT.getEditText().getText().toString().trim();
//
//
//        if(val.isEmpty()){
//            TXTL_signup_SDT.setError(getResources().getString(string.not_empty));
//            return false;
//        }else if(val.length() != 10){
//            TXTL_signup_SDT.setError("Số điện thoại không hợp lệ!");
//            return false;
//        }
//        else {
//            TXTL_signup_SDT.setError(null);
//            TXTL_signup_SDT.setErrorEnabled(false);
//            return true;
//        }
//    }
//
//    private boolean validatePassWord(){
//        String val = TXTL_signup_MatKhau.getEditText().getText().toString().trim();
//
//        if(val.isEmpty()){
//            TXTL_signup_MatKhau.setError(getResources().getString(string.not_empty));
//            return false;
//        }else if(!PASSWORD_PATTERN.matcher(val).matches()){
//            TXTL_signup_MatKhau.setError("Mật khẩu ít nhất 6 ký tự!");
//            return false;
//        }
//        else {
//            TXTL_signup_MatKhau.setError(null);
//            TXTL_signup_MatKhau.setErrorEnabled(false);
//            return true;
//        }
//    }
    //endregion
}