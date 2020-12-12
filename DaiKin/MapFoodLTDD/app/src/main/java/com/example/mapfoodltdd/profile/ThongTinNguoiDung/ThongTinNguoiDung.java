package com.example.mapfoodltdd.profile.ThongTinNguoiDung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.profile.DiaChi;
import com.example.mapfoodltdd.profile.ProfileFragment;

public class ThongTinNguoiDung extends AppCompatActivity {

    ImageView back;
    ImageView DoiAvatar,DoiSoDT,DoiTen,DoiEmail,ChonNghe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinnguoidung);

        back=(ImageView) findViewById(R.id.imageViewback);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });

        DoiAvatar=(ImageView) findViewById(R.id.imageView4);
        DoiAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoiAvatar();
            }
        });

        DoiSoDT=(ImageView) findViewById(R.id.imageView3);
        DoiSoDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoiSoDT();
            }
        });
        DoiTen=(ImageView) findViewById(R.id.imageView5);
        DoiTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoiTen();
            }
        });
        DoiEmail=(ImageView) findViewById(R.id.imageView6);
        DoiEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoiEmail();
            }
        });
        ChonNghe=(ImageView) findViewById(R.id.imageView10);
        ChonNghe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoiNghe();
            }
        });
    }
    public void openDoiSoDT() {
        Intent intent = new Intent(this, DoiSoDT.class);
        startActivity(intent);
        finish();
    }
    public void openDoiAvatar() {
        Intent intent = new Intent(this, DoiAvatar.class);
        startActivity(intent);
        finish();
    }
    public void openDoiTen() {
        Intent intent = new Intent(this, DoiTen.class);
        startActivity(intent);
        finish();
    }
    public void openDoiEmail() {
        Intent intent = new Intent(this, DoiEmail.class);
        startActivity(intent);
        finish();
    }
    public void openDoiNghe() {
        Intent intent = new Intent(this, ChonNghe.class);
        startActivity(intent);
        finish();
    }
    public void openMainActivity(){
        Intent intent=new Intent(ThongTinNguoiDung.this, ProfileFragment.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
}