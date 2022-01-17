package com.sinhvien.coffee_mobileapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sinhvien.coffee_mobileapp.DTO.CategoryDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;

public class AdapterRecycleViewCategory extends RecyclerView.Adapter<AdapterRecycleViewCategory.ViewHolder>{

    Context context;
    int layout;
    List<CategoryDTO> listCategory;

    public AdapterRecycleViewCategory(Context context, int layout, List<CategoryDTO> listCategory){
        this.context = context;
        this.layout = layout;
        this.listCategory = listCategory;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryDTO categoryDTO = listCategory.get(position);
        holder.txt_customcategory_TenLoai.setText(categoryDTO.getCategoryName());
    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_customcategory_TenLoai;
        ImageView img_customcategory_HinhLoai;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txt_customcategory_TenLoai = itemView.findViewById(R.id.txt_customcategory_TenLoai);
            img_customcategory_HinhLoai = itemView.findViewById(R.id.img_customcategory_HinhLoai);
        }
    }

}
