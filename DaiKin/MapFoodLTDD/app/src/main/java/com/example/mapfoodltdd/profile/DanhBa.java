package com.example.mapfoodltdd.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mapfoodltdd.R;

public class DanhBa extends AppCompatActivity {

    ImageView back3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhba);
        back3=(ImageView) findViewById(R.id.back3);
        back3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDiaChi2();
            }
        });
    }
    public void openDiaChi2(){
        Intent intent=new Intent(this,TaoDiaChi.class);
        startActivity(intent);
    }
}