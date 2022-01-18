package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sinhvien.coffee_mobileapp.Adapter.AdapterDisplayPayment;
import com.sinhvien.coffee_mobileapp.DAO.OrderDAO;
import com.sinhvien.coffee_mobileapp.DAO.PaymentDAO;
import com.sinhvien.coffee_mobileapp.DAO.TableDAO;
import com.sinhvien.coffee_mobileapp.DTO.PaymentDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView IMG_payment_backbtn;
    TextView TXT_payment_TenBan, TXT_payment_NgayDat, TXT_payment_TongTien;
    Button BTN_payment_ThanhToan;
    GridView gvDisplayPayment;
    OrderDAO orderDAO;
    TableDAO tableDAO;
    PaymentDAO paymentDAO;
    List<PaymentDTO> listPayment;
    AdapterDisplayPayment adapterDisplayPayment;
    long tongtien = 0;
    int maban, madondat;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_layout);

        //region thuộc tính view
        gvDisplayPayment= (GridView)findViewById(R.id.gvDisplayPayment);
        IMG_payment_backbtn = (ImageView)findViewById(R.id.img_payment_backbtn);
        TXT_payment_TenBan = (TextView)findViewById(R.id.txt_payment_TenBan);
        TXT_payment_NgayDat = (TextView)findViewById(R.id.txt_payment_NgayDat);
        TXT_payment_TongTien = (TextView)findViewById(R.id.txt_payment_TongTien);
        BTN_payment_ThanhToan = (Button)findViewById(R.id.btn_payment_ThanhToan);
        //endregion

        //khởi tạo kết nối csdl
        orderDAO = new OrderDAO();
        paymentDAO = new PaymentDAO();
        tableDAO = new TableDAO();

        fragmentManager = getSupportFragmentManager();

        //lấy data từ mã bàn đc chọn
        Intent intent = getIntent();
        maban = intent.getIntExtra("maban",0);
        String tenban = intent.getStringExtra("tenban");
        String ngaydat = intent.getStringExtra("ngaydat");

        TXT_payment_TenBan.setText(tenban);
        TXT_payment_NgayDat.setText(ngaydat);

        //ktra mã bàn tồn tại thì hiển thị
        if(maban !=0 ){
            HienThiThanhToan();

            for (int i=0;i<listPayment.size();i++){
                int soluong = listPayment.get(i).getNumber();
                float giatien = listPayment.get(i).getPrice();

                tongtien += (soluong * giatien);
            }
            TXT_payment_TongTien.setText(String.valueOf(tongtien));
        }

        BTN_payment_ThanhToan.setOnClickListener(this);
        IMG_payment_backbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_payment_ThanhToan:
//                boolean ktraban = tableDAO.CapNhatTinhTrangBan(maban,"false");
//                boolean ktradondat = orderDAO.UpdateTThaiDonTheoMaBan(maban,"true");
//                boolean ktratongtien = orderDAO.UpdateTongTienDonDat(madondat,String.valueOf(tongtien));
//                if(ktraban && ktradondat && ktratongtien){
//                    HienThiThanhToan();
//                    TXT_payment_TongTien.setText("0 VNĐ");
//                    Toast.makeText(getApplicationContext(),"Thanh toán thành công!",Toast.LENGTH_SHORT);
//                }else{
//                    Toast.makeText(getApplicationContext(),"Lỗi thanh toán!",Toast.LENGTH_SHORT);
//                }
                break;

            case R.id.img_payment_backbtn:
                finish();
                break;
        }
    }

    //hiển thị data lên gridview
    private void HienThiThanhToan(){
        madondat = (int) orderDAO.getOrderIdByTableId(maban);
        listPayment = paymentDAO.getDrinkByOrderId(madondat);
        adapterDisplayPayment = new AdapterDisplayPayment(this,R.layout.custom_layout_paymentmenu,listPayment);
        gvDisplayPayment.setAdapter(adapterDisplayPayment);
        adapterDisplayPayment.notifyDataSetChanged();
    }
}