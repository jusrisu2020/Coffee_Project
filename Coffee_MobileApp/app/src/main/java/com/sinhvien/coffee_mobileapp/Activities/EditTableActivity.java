package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.sinhvien.coffee_mobileapp.DAO.TableDAO;
import com.sinhvien.coffee_mobileapp.R;

public class EditTableActivity extends AppCompatActivity {

    TextInputLayout tipl_EditTable;
    Button btn_EditTable;
    TableDAO tableDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittable_layout);

        tipl_EditTable = findViewById(R.id.tipl_EditTable);
        btn_EditTable = (Button)findViewById(R.id.btn_EditTable);
        Bundle bundle = getIntent().getExtras();

        tipl_EditTable.getEditText().setText(bundle.getString("tableName"));
        tableDAO = new TableDAO();
        btn_EditTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = tipl_EditTable.getEditText().getText().toString();

                int tableId = bundle.getInt("tableId");
                if(tableName != null || tableName.equals("")){
                    boolean checkEditTable = tableDAO.EditTable(tableName, tableId);
                    //trả về result cho displaytable
                    Intent intent = new Intent();
                    intent.putExtra("checkEditTable",checkEditTable);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}