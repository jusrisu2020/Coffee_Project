package com.sinhvien.coffee_mobileapp.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

import com.sinhvien.coffee_mobileapp.Activities.AddCategoryActivity;
import com.sinhvien.coffee_mobileapp.Activities.HomeActivity;
import com.sinhvien.coffee_mobileapp.Adapter.AdapterDisplayCategory;
import com.sinhvien.coffee_mobileapp.DAO.CategoryDAO;
import com.sinhvien.coffee_mobileapp.DTO.CategoryDTO;
import com.sinhvien.coffee_mobileapp.R;

import java.util.List;


public class DisplayCategoryFragment extends Fragment {

    GridView gvCategory;
    List<CategoryDTO> listCategory;
    CategoryDAO categoryDAO;
    AdapterDisplayCategory adapterDisplayCategory;
    FragmentManager fragmentManager;
    int tableId;

    ActivityResultLauncher<Intent> resultLauncherCategory = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        boolean ktra = intent.getBooleanExtra("ktra",false);
                        String chucnang = intent.getStringExtra("chucnang");
                        if(chucnang.equals("themloai"))
                        {
                            if(ktra){
                                HienThiDSLoai();
                                Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getActivity(),"Thêm thất bại",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            if(ktra){
                                HienThiDSLoai();
                                Toast.makeText(getActivity(),"Sủa thành công",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getActivity(),"sửa thất bại",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }
            });


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.displaycategory_layout,container,false);
        setHasOptionsMenu(true);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle("Quản lý thực đơn");

        gvCategory = (GridView)view.findViewById(R.id.gvCategory);

        fragmentManager = getActivity().getSupportFragmentManager();

        categoryDAO = new CategoryDAO();
        HienThiDSLoai();

        Bundle bDataCategory = getArguments();
        if(bDataCategory != null){
            tableId = bDataCategory.getInt("maban");
        }

        gvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int maloai = listCategory.get(position).getId();
                String tenloai = listCategory.get(position).getCategoryName();
                DisplayMenuFragment displayMenuFragment = new DisplayMenuFragment();
//                Bundle bundle = new Bundle();
//                bundle.putInt("maloai",maloai);
//                bundle.putString("tenloai",tenloai);
//                bundle.putInt("maban",maban);
//                displayMenuFragment.setArguments(bundle);

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.contentView,displayMenuFragment).addToBackStack("hienthiloai");
                transaction.commit();
            }
        });

        registerForContextMenu(gvCategory);

        return view;
    }

    //hiển thị contextmenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.edit_delete_context_menu,menu);
    }

    //xử lí context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri = menuInfo.position;
        int maloai = listCategory.get(vitri).getId();

        switch (id){
            case R.id.itEdit:
                Intent iEdit = new Intent(getActivity(), AddCategoryActivity.class);
                iEdit.putExtra("maloai",maloai);
                resultLauncherCategory.launch(iEdit);
                break;

            case R.id.itDelete:
//                boolean ktra = categoryDAO.XoaLoaiMon(maloai);
//                if(ktra){
//                    HienThiDSLoai();
//                    Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.delete_sucessful)
//                            ,Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.delete_failed)
//                            ,Toast.LENGTH_SHORT).show();
//                }
                break;
        }

        return true;
    }

    //khởi tạo nút thêm loại
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem itAddCategory = menu.add(1,R.id.itAddCategory,1,R.string.addCategory);
        itAddCategory.setIcon(R.drawable.ic_baseline_add_24);
        itAddCategory.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    //xử lý nút thêm loại
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itAddCategory:
                Intent intent = new Intent(getActivity(), AddCategoryActivity.class);
                resultLauncherCategory.launch(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //hiển thị dữ liệu trên gridview
    private void HienThiDSLoai(){
        listCategory = categoryDAO.getCategories();
        adapterDisplayCategory = new AdapterDisplayCategory(getActivity(),R.layout.custom_layout_displaycategory,listCategory);
        gvCategory.setAdapter(adapterDisplayCategory);
        adapterDisplayCategory.notifyDataSetChanged();
    }
}