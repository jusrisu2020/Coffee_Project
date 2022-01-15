package com.sinhvien.coffee_mobileapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sinhvien.coffee_mobileapp.Activities.HomeActivity;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;

public class DisplayHomeFragment extends Fragment implements View.OnClickListener{

    RecyclerView rcv_displayhome_LoaiMon, rcv_displayhome_DonTrongNgay;
    RelativeLayout layout_displayhome_ThongKe,layout_displayhome_XemBan, layout_displayhome_XemMenu, layout_displayhome_XemNV;
    TextView txt_displayhome_ViewAllCategory, txt_displayhome_ViewAllStatistic;
//    LoaiMonDAO loaiMonDAO;
//    DonDatDAO donDatDAO;
//    List<LoaiMonDTO> loaiMonDTOList;
//    List<DonDatDTO> donDatDTOS;
//    AdapterRecycleViewCategory adapterRecycleViewCategory;
//    AdapterRecycleViewStatistic adapterRecycleViewStatistic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.displayhome_layout,container,false);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle("Trang Chủ");
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}