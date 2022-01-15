package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sinhvien.coffee_mobileapp.DAO.UserDAO;
import com.sinhvien.coffee_mobileapp.DTO.UserDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.Calendar;

public class Register2ndActivity extends AppCompatActivity{

    ImageView imgv_Register2ndBack;
    RadioGroup rg_RegisterGender;
    DatePicker dp_DateOfBirth;
    Button btn_Register;
    String fullName, phone,userName,password, dateOfBirth;
    int gender = 0;
    UserDAO userDAO;
//    QuyenDAO quyenDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2nd_layout);

        imgv_Register2ndBack = findViewById(R.id.imgv_Register2ndBack);
        rg_RegisterGender = (RadioGroup) findViewById(R.id.rg_RegisterGender);
        dp_DateOfBirth = (DatePicker) findViewById(R.id.dp_DateOfBirth);
        btn_Register = (Button) findViewById(R.id.btn_Register);

        //lấy dữ liệu từ bundle của register1
        Bundle bundle = getIntent().getBundleExtra(RegisterActivity.DataRegisterUserBundel);
        if (bundle != null) {
            fullName = bundle.getString("fullName");
            phone = bundle.getString("phone");
            userName = bundle.getString("userName");
            password = bundle.getString("password");
            //khởi tạo kết nối csdl
            userDAO = new UserDAO();
//        quyenDAO = new QuyenDAO(this);

            btn_Register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                if(!validateAge() | !validateGender()){
//                    return;
//                }

                    //lấy các thông tin còn lại
                    switch (rg_RegisterGender.getCheckedRadioButtonId()) {
                        case R.id.rb_GenderMale:
                            gender = 1;
                            break;
                        case R.id.rb_GenderFeMale:
                            gender = 2;
                            break;
                        case R.id.rb_GenderOther:
                            gender = 3;
                            break;
                    }
                    dateOfBirth = dp_DateOfBirth.getYear() + "-" + (dp_DateOfBirth.getMonth() + 1) + "-" + dp_DateOfBirth.getDayOfMonth();

                    //truyền dữ liệu vào obj nhanvienDTO
                    UserDTO userDTO = new UserDTO();
                    userDTO.setFullName(fullName);
                    userDTO.setGender(gender);
                    userDTO.setPhone(phone);
                    userDTO.setDateOfBirth(dateOfBirth);
                    userDTO.setUserName(userName);
                    userDTO.setPassword(password);


                    //Thêm nv dựa theo obj nhanvienDTO
                    if (userDAO.CreateUser(userDTO)) {
                        Toast.makeText(Register2ndActivity.this, getResources().getString(R.string.add_sucessful), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else {
                        Toast.makeText(Register2ndActivity.this, getResources().getString(R.string.add_failed), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            imgv_Register2ndBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
}