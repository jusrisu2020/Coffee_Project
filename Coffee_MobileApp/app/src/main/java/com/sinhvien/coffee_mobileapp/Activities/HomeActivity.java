package com.sinhvien.coffee_mobileapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import com.sinhvien.coffee_mobileapp.Fragment.DisplayHomeFragment;
import com.sinhvien.coffee_mobileapp.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    MenuItem selectedFeature, selectedManager;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    TextView tv_Menu_UserName;
    int maquyen = 0;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        //region thuộc tính bên view
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view_trangchu);
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        View view = navigationView.getHeaderView(0);
        tv_Menu_UserName = (TextView) view.findViewById(R.id.tv_Menu_UserName);
        //endregion

        //xử lý toolbar và navigation
        setSupportActionBar(toolbar); //tạo toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //tạo nút mở navigation
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opentoggle,R.string.closetoggle){
            @Override
            public void onDrawerOpened(View drawerView) {    super.onDrawerOpened(drawerView); }

            @Override
            public void onDrawerClosed(View drawerView) {    super.onDrawerClosed(drawerView); }
        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //Tụ động gán tên nv đăng nhập qua Extras
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        tv_Menu_UserName.setText( "Xin chào " + userName +" !!");

        //lấy file share prefer
        sharedPreferences = getSharedPreferences("luuquyen", Context.MODE_PRIVATE);
        maquyen = sharedPreferences.getInt("maquyen",0);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction tranDisplayHome = fragmentManager.beginTransaction();
        DisplayHomeFragment displayHomeFragment = new DisplayHomeFragment();
        tranDisplayHome.replace(R.id.contentView, displayHomeFragment);
        tranDisplayHome.commit();
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                FragmentTransaction tranDisplayHome = fragmentManager.beginTransaction();
                DisplayHomeFragment displayHomeFragment = new DisplayHomeFragment();
                tranDisplayHome.replace(R.id.contentView,displayHomeFragment);
                tranDisplayHome.commit();
                navigationView.setCheckedItem(item.getItemId());
                drawerLayout.closeDrawers();
                break;
        }
        return false;
    }
}