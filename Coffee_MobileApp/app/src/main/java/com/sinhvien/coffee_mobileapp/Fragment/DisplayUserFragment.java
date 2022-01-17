package com.sinhvien.coffee_mobileapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.sinhvien.coffee_mobileapp.Activities.HomeActivity;
import com.sinhvien.coffee_mobileapp.Adapter.AdapterDisplayUser;
import com.sinhvien.coffee_mobileapp.DAO.UserDAO;
import com.sinhvien.coffee_mobileapp.DTO.UserDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;


public class DisplayUserFragment extends Fragment {

    GridView gvUser;
    UserDAO userDAO;
    List<UserDTO> listUserDTO;
    AdapterDisplayUser adapterDisplayUser;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.displayuser_layout,container,false);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle("Quản lý người dùng");
        setHasOptionsMenu(true);
        gvUser = (GridView)view.findViewById(R.id.gvUser) ;
        userDAO = new UserDAO();
        showUsers();
        registerForContextMenu(gvUser);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem itAddStaff = itAddStaff = menu.add(1,R.id.itUpdateStatus,1,"Khóa tài khoản");
        itAddStaff.setIcon(R.drawable.ic_baseline_add_24);
        itAddStaff.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    private void showUsers(){
        listUserDTO = userDAO.getUsers();
        adapterDisplayUser = new AdapterDisplayUser(getActivity(),R.layout.custom_layout_displayuser,listUserDTO);
        gvUser.setAdapter(adapterDisplayUser);
        adapterDisplayUser.notifyDataSetChanged();
    }
}