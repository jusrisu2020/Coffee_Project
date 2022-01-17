package com.sinhvien.coffee_mobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinhvien.coffee_mobileapp.DTO.UserDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;

public class AdapterDisplayUser extends BaseAdapter {

    Context context;
    int layout;
    List<UserDTO> listUserDTO;
    ViewHolder viewHolder;

    public AdapterDisplayUser(Context context, int layout, List<UserDTO> listUserDTO){
        this.context = context;
        this.layout = layout;
        this.listUserDTO = listUserDTO;
    }

    @Override
    public int getCount() {
        return listUserDTO.size();
    }

    @Override
    public Object getItem(int position) {
        return listUserDTO.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listUserDTO.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,parent,false);

//            viewHolder.imgv_UserAvatar = (ImageView)view.findViewById(R.id.imgv_UserAvatar);
//            viewHolder.txt_customstaff_TenNV = (TextView)view.findViewById(R.id.txt_customstaff_TenNV);
//            viewHolder.txt_customstaff_TenQuyen = (TextView)view.findViewById(R.id.txt_customstaff_TenQuyen);
//            viewHolder.txt_customstaff_SDT = (TextView)view.findViewById(R.id.txt_customstaff_SDT);
//            viewHolder.txt_customstaff_Email = (TextView)view.findViewById(R.id.txt_customstaff_Email);

//                    tv_UserFullName
//            tv_UserGender
//                    tv_UserTypeUser
//            tv_UserPhone
//                    tv_UserDateOfBirth
//            tv_UserStatus

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        UserDTO userDTO = listUserDTO.get(position);

        viewHolder.txt_customstaff_TenNV.setText(userDTO.getFullName());
        viewHolder.txt_customstaff_SDT.setText(userDTO.getPhone());
//        viewHolder.txt_customstaff_Email.setText(userDTO.getGender());

        return view;
    }

    public class ViewHolder{
        ImageView img_customstaff_HinhNV;
        TextView txt_customstaff_TenNV, txt_customstaff_TenQuyen,txt_customstaff_SDT, txt_customstaff_Email;
    }
}
