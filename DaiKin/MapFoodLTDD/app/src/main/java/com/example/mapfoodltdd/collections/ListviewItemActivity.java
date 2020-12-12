package com.example.mapfoodltdd.collections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.collections.tabchitietquananyeuthich.binhluan.binhluan;
import com.example.mapfoodltdd.collections.tabchitietquananyeuthich.giaohang.giaonhang;
import com.example.mapfoodltdd.collections.tabchitietquananyeuthich.thongtin.thongtin;
import com.example.mapfoodltdd.home.Adapter.SectionPagerAdapterHome;
import com.example.mapfoodltdd.home.TabHome.BanChay.BanChayFragment;
import com.example.mapfoodltdd.home.TabHome.GanToi.GanToiFragment;
import com.google.android.material.tabs.TabLayout;

public class ListviewItemActivity extends AppCompatActivity {

    TextView iddongho106, idgia;
    ImageView imageView106;
    ImageView back106;
    ViewPager viewPagerct106;
    TabLayout tabLayoutct106;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_listitem );

        iddongho106 = findViewById ( R.id.idTitle );
        imageView106 = findViewById ( R.id.imageView );
        Intent intent = getIntent ();
        String receivedName = intent.getStringExtra ( "name" );
        int receivedImage = intent.getIntExtra ( "image", 0 );

        iddongho106.setText ( receivedName );
        imageView106.setImageResource ( receivedImage );

        back106 = (ImageView) findViewById ( R.id.back );
        back106.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openXemThemActivity ();
            }

            private void openXemThemActivity() {
                Intent intent = new Intent ( ListviewItemActivity.this, Xemthem.class );
                intent.setFlags ( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                finish ();
            }
        } );

        viewPagerct106 = findViewById(R.id.viewPagerctcolection);
        tabLayoutct106 = findViewById(R.id.tabLayoutctcolection);
        setUpViewPagerHome(viewPagerct106);
        tabLayoutct106.setupWithViewPager(viewPagerct106);
        tabLayoutct106.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

        adapter.addFragment(new giaonhang(), "Giao hàng");
        adapter.addFragment(new binhluan(), "Bình luận");
        adapter.addFragment(new thongtin(), "Thông tin");
        viewPagerct106.setAdapter(adapter);
    }
}