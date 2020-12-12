package com.example.mapfoodltdd.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.home.Adapter.SectionPagerAdapterHome;
import com.example.mapfoodltdd.home.IconMenu.IconMenuAdapter;
import com.example.mapfoodltdd.home.IconMenu.ListIcon;
import com.example.mapfoodltdd.home.IconMenu.chitieticonmenu.ChiTietIconMenuActivity;
import com.example.mapfoodltdd.home.Map.MapActivity;
import com.example.mapfoodltdd.home.TabHome.BanChay.BanChayFragment;
import com.example.mapfoodltdd.home.TabHome.DanhGia.DanhGiaFragment;
import com.example.mapfoodltdd.home.TabHome.GanToi.GanToiFragment;
import com.example.mapfoodltdd.home.TabHome.GiaoNhanh.GiaoNhanhFragment;
import com.example.mapfoodltdd.home.bosuutap1.Bosuutap1Adapter;
import com.example.mapfoodltdd.home.bosuutap1.GridBosuutap.GridItemBSTActivity;
import com.example.mapfoodltdd.home.bosuutap1.GridBosuutap.XemThemBSTActivity;
import com.example.mapfoodltdd.home.bosuutap1.ListBoSuuTap1;
import com.example.mapfoodltdd.home.listprovince.ListProvince;
import com.example.mapfoodltdd.home.tonghopicon.TongHopIconAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TextView txtProvince, txtmap,txtxemthembst;
    RecyclerView recyclerViewbosuutap;
    private View root;
    public EditText txtlocation;
    Context context;
    RecyclerView mList1,mList2,mListbst1,mListthicon;
    List<ListIcon> appList1,appList2,appListthicon;
    List<ListBoSuuTap1> appListbst1;
    ViewPager viewPagerhome;
    TabLayout tabLayouthome;
    private MapActivity mMapActivity;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    interface FragmentCallback {
        void onClickButton(HomeFragment fragment);
    }
    private FragmentCallback mCallback;
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        context=getActivity();
        root = inflater.inflate(R.layout.fragment_home, container, false);

        //Xem thêm bộ sưu tập
        txtxemthembst=root.findViewById(R.id.xemthembst);
        txtxemthembst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openXemThemBoSuuTap();
            }
        });
        
        //Chuyển map ->Home Fragment
//        txtlocation= root.findViewById(R.id.txt_destination);
//        txtlocation.setText(mMapActivity.getMlocation());

        //Icon menu


        // List Icon
        mList1 = root.findViewById(R.id.listicon1);
        mListbst1=root.findViewById(R.id.listbst1);
        appList1 = new ArrayList<>();
        appListbst1= new ArrayList<>();




        appList1.add(new ListIcon(R.drawable.doitac,"Bảo trì"));
        appList1.add(new ListIcon(R.drawable.nowship,"Sửa chữa"));
        appList1.add(new ListIcon(R.drawable.nowtable,"E-Shop"));
        appList1.add(new ListIcon(R.drawable.sieuthi,"Phụ kiện"));
        appList1.add(new ListIcon(R.drawable.giupviec,"Zalo Us"));

        GridLayoutManager manager1 = new GridLayoutManager(HomeFragment.this.getActivity(),2);
        manager1.setOrientation(GridLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        IconMenuAdapter adaptor1 = new IconMenuAdapter(HomeFragment.this.getActivity(),appList1);
        mList1.setAdapter(adaptor1);



        // List Bộ siêu tập1
        appListbst1.add(new ListBoSuuTap1(1,R.drawable.bst1,"Máy điều hòa treo tường"));
        appListbst1.add(new ListBoSuuTap1(2,R.drawable.bst2,"Máy điều hòa Sky Airs"));
        appListbst1.add(new ListBoSuuTap1(3,R.drawable.bst3,"Máy điều hòa VRV"));
        appListbst1.add(new ListBoSuuTap1(4,R.drawable.bst4,"Máy điều hòa Multi"));
        appListbst1.add(new ListBoSuuTap1(5,R.drawable.bst5,"Máy lọc không khí"));

        LinearLayoutManager manager3 = new LinearLayoutManager(HomeFragment.this.getActivity());
        manager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        mListbst1.setLayoutManager(manager3);

        Bosuutap1Adapter adaptor3 = new Bosuutap1Adapter(HomeFragment.this.getActivity(),appListbst1);
        mListbst1.setAdapter(adaptor3);

        // List tổng hợp icon


        //ImageSlider

        ImageSlider imageSlider = (ImageSlider) root.findViewById ( R.id.slide );
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add ( new SlideModel (R.drawable.pn1) );
        slideModels.add ( new SlideModel (R.drawable.pn2) );
        slideModels.add ( new SlideModel (R.drawable.pn3) );
        slideModels.add ( new SlideModel (R.drawable.pn4) );
        slideModels.add ( new SlideModel (R.drawable.pn5) );
        imageSlider.setImageList ( slideModels,true );

        txtProvince = root.findViewById(R.id.listprovince);
        txtProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListprovince();
            }
        });
        txtmap = root.findViewById(R.id.textlocation);
        txtmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
//        initUI();

        return root;
    }

//    private void initUI() {
//
//        txtlocation=root.findViewById(R.id.txt_destination);
//    }






// Intent
    public void openListprovince(){
        Intent intent=new Intent(HomeFragment.this.getActivity(), ListProvince.class);
        startActivity(intent);
    }
    public void openMap(){
        Intent intent=new Intent(HomeFragment.this.getActivity(), MapActivity.class);
        startActivity(intent);
    }
    public void openXemThemBoSuuTap(){
        Intent intent=new Intent(HomeFragment.this.getActivity(), XemThemBSTActivity.class);
        startActivity(intent);
    }
    public void openChiTietIconMenu(){
        Intent intent=new Intent(HomeFragment.this.getActivity(), ChiTietIconMenuActivity.class);
        startActivity(intent);
    }

}