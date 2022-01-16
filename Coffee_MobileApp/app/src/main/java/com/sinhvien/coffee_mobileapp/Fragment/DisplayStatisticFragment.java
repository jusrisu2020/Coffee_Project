package com.sinhvien.coffee_mobileapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sinhvien.coffee_mobileapp.Activities.HomeActivity;
import com.sinhvien.coffee_mobileapp.DAO.StatisticDAO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;


public class DisplayStatisticFragment extends Fragment {

    ListView lvStatistic;
//    List<DonDatDTO> donDatDTOS;
    StatisticDAO statisticDAO;
//    AdapterDisplayStatistic adapterDisplayStatistic;
    FragmentManager fragmentManager;
    int madon, manv, maban;
    String ngaydat, tongtien;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.displaystatistic_layout, container, false);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle("Quản lý thống kê");
        setHasOptionsMenu(true);

        lvStatistic = (ListView)view.findViewById(R.id.lvStatistic);
        statisticDAO = new StatisticDAO();

//        donDatDTOS = donDatDAO.LayDSDonDat();
//        adapterDisplayStatistic = new AdapterDisplayStatistic(getActivity(),R.layout.custom_layout_displaystatistic,donDatDTOS);
//        lvStatistic.setAdapter(adapterDisplayStatistic);
//        adapterDisplayStatistic.notifyDataSetChanged();
        lvStatistic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                madon = donDatDTOS.get(position).getMaDonDat();
//                manv = donDatDTOS.get(position).getMaNV();
//                maban = donDatDTOS.get(position).getMaBan();
//                ngaydat = donDatDTOS.get(position).getNgayDat();
//                tongtien = donDatDTOS.get(position).getTongTien();
//
//                Intent intent = new Intent(getActivity(), DetailStatisticActivity.class);
//                intent.putExtra("madon",madon);
//                intent.putExtra("manv",manv);
//                intent.putExtra("maban",maban);
//                intent.putExtra("ngaydat",ngaydat);
//                intent.putExtra("tongtien",tongtien);
//                startActivity(intent);
            }
        });
        return view;
    }
}