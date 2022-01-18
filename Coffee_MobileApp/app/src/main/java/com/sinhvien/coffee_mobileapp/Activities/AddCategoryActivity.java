package com.sinhvien.coffee_mobileapp.Activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.sinhvien.coffee_mobileapp.DAO.CategoryDAO;
import com.sinhvien.coffee_mobileapp.DTO.CategoryDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddCategoryActivity extends AppCompatActivity implements View.OnClickListener{

    Button BTN_addcategory_TaoLoai;
    ImageView IMG_addcategory_back, IMG_addcategory_ThemHinh;
    TextView TXT_addcategory_title;
    TextInputLayout TXTL_addcategory_TenLoai;
    CategoryDAO categoryDAO;
    int maloai = 0;
    Bitmap bitmapold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcategory_layout);

        categoryDAO = new CategoryDAO();

        //region Lấy đối tượng view
        BTN_addcategory_TaoLoai = (Button)findViewById(R.id.btn_addcategory_TaoLoai);
        TXTL_addcategory_TenLoai = (TextInputLayout)findViewById(R.id.txtl_addcategory_TenLoai);
        IMG_addcategory_back = (ImageView)findViewById(R.id.img_addcategory_back);
        IMG_addcategory_ThemHinh = (ImageView)findViewById(R.id.img_addcategory_ThemHinh);
        TXT_addcategory_title = (TextView)findViewById(R.id.txt_addcategory_title);
        //endregion

        BitmapDrawable olddrawable = (BitmapDrawable)IMG_addcategory_ThemHinh.getDrawable();
        bitmapold = olddrawable.getBitmap();

        //region Hiển thị trang sửa nếu được chọn từ context menu sửa
        maloai = getIntent().getIntExtra("maloai",0);
        if(maloai != 0){
            TXT_addcategory_title.setText(getResources().getString(R.string.editcategory));
            CategoryDTO categoryDTO = categoryDAO.getCategoryById(maloai);

            //Hiển thị lại thông tin từ csdl
            TXTL_addcategory_TenLoai.getEditText().setText(categoryDTO.getCategoryName());
            BTN_addcategory_TaoLoai.setText("Sửa loại");
        }
        //endregion

        IMG_addcategory_back.setOnClickListener(this);
        IMG_addcategory_ThemHinh.setOnClickListener(this);
        BTN_addcategory_TaoLoai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        boolean ktra;
        String chucnang;
        switch (id){
            case R.id.img_addcategory_back:
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right); //animation
                break;

            case R.id.btn_addcategory_TaoLoai:
                if(!validateName()){
                    return;
                }

                String sTenLoai = TXTL_addcategory_TenLoai.getEditText().getText().toString();
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryName(sTenLoai);
                if(maloai != 0){
                    ktra = categoryDAO.EditCategory(categoryDTO,maloai);
                    chucnang = "sualoai";
                }else {
                    ktra = categoryDAO.CreateCategory(categoryDTO);
                    chucnang = "themloai";
                }

                //Thêm, sửa loại dựa theo obj loaimonDTO
                Intent intent = new Intent();
                intent.putExtra("ktra",ktra);
                intent.putExtra("chucnang",chucnang);
                setResult(RESULT_OK,intent);
                finish();
                break;

        }
    }

    private boolean validateName(){
        String val = TXTL_addcategory_TenLoai.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            TXTL_addcategory_TenLoai.setError(getResources().getString(R.string.not_empty));
            return false;
        }else {
            TXTL_addcategory_TenLoai.setError(null);
            TXTL_addcategory_TenLoai.setErrorEnabled(false);
            return true;
        }
    }
}