package com.example.mapfoodltdd.home.IconMenu.chitieticonmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.home.Adapter.SectionPagerAdapterHome;
import com.example.mapfoodltdd.home.HomeFragment;
import com.example.mapfoodltdd.home.TabHome.BanChay.BanChayFragment;
import com.example.mapfoodltdd.home.TabHome.GanToi.GanToiFragment;
import com.example.mapfoodltdd.home.bosuutap1.GridBosuutap.GridItemBSTActivity;
import com.example.mapfoodltdd.home.bosuutap1.GridBosuutap.XemThemBSTActivity;
import com.example.mapfoodltdd.home.listprovince.ListProvince;
import com.google.android.material.tabs.TabLayout;

public class ChiTietIconMenuActivity extends AppCompatActivity {

    ViewPager viewPagerhome;
    TabLayout tabLayouthome;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_icon_menu);

        back=(ImageView) findViewById(R.id.idbackiconhome);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openHomeFragment();
            }
        });
        viewPagerhome = findViewById(R.id.viewPagerbst);
        tabLayouthome = findViewById(R.id.tabLayoutbst);
        setUpViewPagerHome(viewPagerhome);
        tabLayouthome.setupWithViewPager(viewPagerhome);
        tabLayouthome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    private void setUpViewPagerHome(ViewPager viewPager) {
        SectionPagerAdapterHome adapter = new SectionPagerAdapterHome(getSupportFragmentManager());

        adapter.addFragment(new BanChayFragment(), "Gợi ý");
        adapter.addFragment(new GanToiFragment(), "Bán Chạy");
        adapter.addFragment(new BanChayFragment(), "Đánh giá");
        adapter.addFragment(new GanToiFragment(), "Giao nhanh");
        viewPagerhome.setAdapter(adapter);
    }
    public void openHomeFragment() {
        Intent intent = new Intent(ChiTietIconMenuActivity.this, HomeFragment.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
}