package com.sinhvien.coffee_mobileapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sinhvien.coffee_mobileapp.DTO.PaymentDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterDisplayPayment extends BaseAdapter {

    Context context;
    int layout;
    List<PaymentDTO> listPayment;
    ViewHolder viewHolder;

    public AdapterDisplayPayment(Context context, int layout, List<PaymentDTO> listPayment){
        this.context = context;
        this.layout = layout;
        this.listPayment = listPayment;
    }

    @Override
    public int getCount() {
        return listPayment.size();
    }

    @Override
    public Object getItem(int position) {
        return listPayment.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            viewHolder.img_custompayment_HinhMon = (CircleImageView)view.findViewById(R.id.img_custompayment_HinhMon);
            viewHolder.txt_custompayment_TenMon = (TextView)view.findViewById(R.id.txt_custompayment_TenMon);
            viewHolder.txt_custompayment_SoLuong = (TextView)view.findViewById(R.id.txt_custompayment_SoLuong);
            viewHolder.txt_custompayment_GiaTien = (TextView)view.findViewById(R.id.txt_custompayment_GiaTien);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)view.getTag();
        }
        PaymentDTO paymentDTO = listPayment.get(position);

        viewHolder.txt_custompayment_TenMon.setText(paymentDTO.getDrinkName());
        viewHolder.txt_custompayment_SoLuong.setText(String.valueOf(paymentDTO.getNumber()));
        viewHolder.txt_custompayment_GiaTien.setText(String.valueOf(paymentDTO.getPrice()));
        return view;
    }

    public class ViewHolder{
        CircleImageView img_custompayment_HinhMon;
        TextView txt_custompayment_TenMon, txt_custompayment_SoLuong, txt_custompayment_GiaTien;
    }
}
