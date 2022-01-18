package com.sinhvien.coffee_mobileapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinhvien.coffee_mobileapp.Adapter.AdapterDisplayPayment;
import com.sinhvien.coffee_mobileapp.DAO.PaymentDAO;
import com.sinhvien.coffee_mobileapp.DAO.TableDAO;
import com.sinhvien.coffee_mobileapp.DAO.UserDAO;
import com.sinhvien.coffee_mobileapp.DTO.PaymentDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;

public class DetailStatisticActivity extends AppCompatActivity {

    ImageView img_detailstatistic_backbtn;
    TextView txt_detailstatistic_MaDon,txt_detailstatistic_NgayDat,txt_detailstatistic_TenBan
            ,txt_detailstatistic_TenNV,txt_detailstatistic_TongTien;
    GridView gvDetailStatistic;
    int madon, manv, maban;
    String ngaydat, tongtien;
    UserDAO userDAO;
    TableDAO tableDAO;
    List<PaymentDTO> listPayment;
    PaymentDAO paymentDAO;
    AdapterDisplayPayment adapterDisplayPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailstatistic_layout);

        //Lấy thông tin từ display statistic
        Intent intent = getIntent();
        madon = intent.getIntExtra("madon",0);
        manv = intent.getIntExtra("manv",0);
        maban = intent.getIntExtra("maban",0);
        ngaydat = intent.getStringExtra("ngaydat");
        tongtien = intent.getStringExtra("tongtien");

        //region Thuộc tính bên view
        img_detailstatistic_backbtn = (ImageView)findViewById(R.id.img_detailstatistic_backbtn);
        txt_detailstatistic_MaDon = (TextView)findViewById(R.id.txt_detailstatistic_MaDon);
        txt_detailstatistic_NgayDat = (TextView)findViewById(R.id.txt_detailstatistic_NgayDat);
        txt_detailstatistic_TenBan = (TextView)findViewById(R.id.txt_detailstatistic_TenBan);
        txt_detailstatistic_TenNV = (TextView)findViewById(R.id.txt_detailstatistic_TenNV);
        txt_detailstatistic_TongTien = (TextView)findViewById(R.id.txt_detailstatistic_TongTien);
        gvDetailStatistic = (GridView)findViewById(R.id.gvDetailStatistic);
        //endregion

        //khởi tạo lớp dao mở kết nối csdl
//        nhanVienDAO = new NhanVienDAO();
//        banAnDAO = new BanAnDAO();
//        thanhToanDAO = new ThanhToanDAO();

        //chỉ hiển thị nếu lấy đc mã đơn đc chọn
//        if (madon !=0){
//            txt_detailstatistic_MaDon.setText("Mã đơn: "+madon);
//            txt_detailstatistic_NgayDat.setText(ngaydat);
//            txt_detailstatistic_TongTien.setText(tongtien+" VNĐ");
//
//            NhanVienDTO nhanVienDTO = nhanVienDAO.LayNVTheoMa(manv);
//            txt_detailstatistic_TenNV.setText(nhanVienDTO.getHOTENNV());
//            txt_detailstatistic_TenBan.setText(banAnDAO.LayTenBanTheoMa(maban));
//
//            HienThiDSCTDD();
//        }
        img_detailstatistic_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
    }

    private void HienThiDSCTDD(){
        listPayment = paymentDAO.getDrinkByOrderId(madon);
        adapterDisplayPayment = new AdapterDisplayPayment(this,R.layout.custom_layout_paymentmenu,listPayment);
        gvDetailStatistic.setAdapter(adapterDisplayPayment);
        adapterDisplayPayment.notifyDataSetChanged();
    }
}