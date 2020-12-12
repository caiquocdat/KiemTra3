package com.example.mapfoodltdd.profile.ThongTinNguoiDung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.home.HomeFragment;
import com.example.mapfoodltdd.home.listprovince.ListProvince;
import com.example.mapfoodltdd.profile.ProfileFragment;

public class DoiEmail extends AppCompatActivity {

    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_email);
        back=findViewById(R.id.imageView4a);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });
    }
    public void openMainActivity(){
        Intent intent=new Intent(this,ThongTinNguoiDung.class);
        startActivity(intent);
    }
}