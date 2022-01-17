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

            viewHolder.imgv_UserAvatar = (ImageView)view.findViewById(R.id.imgv_UserAvatar);
            viewHolder.tv_UserFullName = (TextView)view.findViewById(R.id.tv_UserFullName);
            viewHolder.tv_UserGender = (TextView)view.findViewById(R.id.tv_UserGender);
            viewHolder.tv_UserPhone = (TextView)view.findViewById(R.id.tv_UserPhone);
            viewHolder.tv_UserDateOfBirth = (TextView)view.findViewById(R.id.tv_UserDateOfBirth);
            viewHolder.tv_UserStatus = (TextView)view.findViewById(R.id.tv_UserStatus);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        UserDTO userDTO = listUserDTO.get(position);

        viewHolder.tv_UserFullName.setText(userDTO.getFullName());

        switch (userDTO.getGender()){
            case 1:
                viewHolder.tv_UserGender.setText("Nam");
                break;
            case 2:
                viewHolder.tv_UserGender.setText("Nữ");
                break;
            case 3:
                viewHolder.tv_UserGender.setText("Khác");
                break;
        }
        viewHolder.tv_UserPhone.setText(userDTO.getPhone());
        viewHolder.tv_UserDateOfBirth.setText(userDTO.getDateOfBirth());
        switch (userDTO.getStatus()){
            case 1:
                viewHolder.tv_UserStatus.setText("Đang hoạt động");
                break;
            case 2:
                viewHolder.tv_UserStatus.setText("Bị khóa");
                break;
        }
        return view;
    }

    public class ViewHolder{
        ImageView imgv_UserAvatar;
        TextView tv_UserFullName, tv_UserGender, tv_UserPhone, tv_UserDateOfBirth, tv_UserStatus;
    }
}
