package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.sinhvien.coffee_mobileapp.DAO.TableDAO;
import com.sinhvien.coffee_mobileapp.R;

public class AddTableActivity extends AppCompatActivity {

    TextInputLayout TXTL_addtable_tenban;
    Button BTN_addtable_TaoBan;
    TableDAO tableDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtable_layout);

        TXTL_addtable_tenban = (TextInputLayout)findViewById(R.id.txtl_addtable_tenban);
        BTN_addtable_TaoBan = (Button)findViewById(R.id.btn_addtable_TaoBan);

        tableDAO = new TableDAO();
        BTN_addtable_TaoBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = TXTL_addtable_tenban.getEditText().getText().toString();
                if(tableName != null || tableName.equals("")){
                    boolean checkAddTable = tableDAO.CreateTable(tableName);
                    //trả về result cho displaytable
                    Intent intent = new Intent();
                    intent.putExtra("checkAddTable",checkAddTable);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}