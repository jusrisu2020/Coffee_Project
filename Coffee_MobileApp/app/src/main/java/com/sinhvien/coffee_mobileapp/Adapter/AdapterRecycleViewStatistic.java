package com.sinhvien.coffee_mobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.coffee_mobileapp.DAO.TableDAO;
import com.sinhvien.coffee_mobileapp.DAO.UserDAO;
import com.sinhvien.coffee_mobileapp.DTO.OrderDTO;
import com.sinhvien.coffee_mobileapp.DTO.UserDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;

public class AdapterRecycleViewStatistic extends RecyclerView.Adapter<AdapterRecycleViewStatistic.ViewHolder>{

    Context context;
    int layout;
    List<OrderDTO> listOrder;
    UserDAO userDAO;
    TableDAO tableDAO;

    public AdapterRecycleViewStatistic(Context context, int layout, List<OrderDTO> listOrder){

        this.context =context;
        this.layout = layout;
        this.listOrder = listOrder;
        userDAO = new UserDAO();
        tableDAO = new TableDAO();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OrderDTO orderDTO = listOrder.get(position);
        holder.txt_customstatistic_MaDon.setText("Mã đơn: "+orderDTO.getId());
        holder.txt_customstatistic_NgayDat.setText(orderDTO.getBookingDate());
        if(orderDTO.getTotal() == 0)
        {
            holder.txt_customstatistic_TongTien.setVisibility(View.INVISIBLE);
        }else {
            holder.txt_customstatistic_TongTien.setVisibility(View.VISIBLE);
        }

        if (orderDTO.getStatus() == 1)
        {
            holder.txt_customstatistic_TrangThai.setText("Đã thanh toán");
        }else {
            holder.txt_customstatistic_TrangThai.setText("Chưa thanh toán");
        }
//        UserDTO userDTO = userDAO.LayNVTheoMa(donDatDTO.getMaNV());
//        holder.txt_customstatistic_TenNV.setText(nhanVienDTO.getHOTENNV());
        holder.txt_customstatistic_BanDat.setText(tableDAO.getTableNameById(orderDTO.getTableId()));
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_customstatistic_MaDon, txt_customstatistic_NgayDat, txt_customstatistic_TenNV,
                txt_customstatistic_BanDat, txt_customstatistic_TongTien,txt_customstatistic_TrangThai;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txt_customstatistic_MaDon = itemView.findViewById(R.id.txt_customstatistic_MaDon);
            txt_customstatistic_NgayDat = itemView.findViewById(R.id.txt_customstatistic_NgayDat);
            txt_customstatistic_TenNV = itemView.findViewById(R.id.txt_customstatistic_TenNV);
            txt_customstatistic_BanDat = itemView.findViewById(R.id.txt_customstatistic_BanDat);
            txt_customstatistic_TongTien = itemView.findViewById(R.id.txt_customstatistic_TongTien);
            txt_customstatistic_TrangThai = itemView.findViewById(R.id.txt_customstatistic_TrangThai);
        }
    }
}
