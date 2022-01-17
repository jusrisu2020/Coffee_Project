package com.sinhvien.coffee_mobileapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinhvien.coffee_mobileapp.DTO.DrinkDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;

public class AdapterDisplayMenu extends BaseAdapter {

    Context context;
    int layout;
    List<DrinkDTO> listDrink;
    Viewholder viewholder;

    //constructor
    public AdapterDisplayMenu(Context context, int layout, List<DrinkDTO> listDrink){
        this.context = context;
        this.layout = layout;
        this.listDrink = listDrink;
    }

    @Override
    public int getCount() {
        return listDrink.size();
    }

    @Override
    public Object getItem(int position) {
        return listDrink.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listDrink.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewholder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

            viewholder.img_custommenu_HinhMon = (ImageView)view.findViewById(R.id.img_custommenu_HinhMon);
            viewholder.txt_custommenu_TenMon = (TextView) view.findViewById(R.id.txt_custommenu_TenMon);
            viewholder.txt_custommenu_TinhTrang = (TextView)view.findViewById(R.id.txt_custommenu_TinhTrang);
            viewholder.txt_custommenu_GiaTien = (TextView)view.findViewById(R.id.txt_custommenu_GiaTien);
            view.setTag(viewholder);
        }else {
            viewholder = (Viewholder) view.getTag();
        }
        DrinkDTO drinkDTO = listDrink.get(position);
        viewholder.txt_custommenu_TenMon.setText(drinkDTO.getDrinkName());
        viewholder.txt_custommenu_GiaTien.setText(drinkDTO.getPrice()+" VNĐ");

        //hiển thị tình trạng của món

        //lấy hình ảnh
//        if(monDTO.getHinhAnh() != null){
//            byte[] menuimage = monDTO.getHinhAnh();
//            Bitmap bitmap = BitmapFactory.decodeByteArray(menuimage,0,menuimage.length);
//            viewholder.img_custommenu_HinhMon.setImageBitmap(bitmap);
//        }else {
//            viewholder.img_custommenu_HinhMon.setImageResource(R.drawable.cafe_americano);
//        }

        return view;
    }

    //tạo viewholer lưu trữ component
    public class Viewholder{
        ImageView img_custommenu_HinhMon;
        TextView txt_custommenu_TenMon, txt_custommenu_GiaTien,txt_custommenu_TinhTrang;
    }
}
