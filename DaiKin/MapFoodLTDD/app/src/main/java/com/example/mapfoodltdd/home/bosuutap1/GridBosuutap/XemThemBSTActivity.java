package com.example.mapfoodltdd.home.bosuutap1.GridBosuutap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.home.HomeFragment;
import com.example.mapfoodltdd.home.IconMenu.ListIcon;
import com.example.mapfoodltdd.home.bosuutap1.Bosuutap1Adapter;
import com.example.mapfoodltdd.home.bosuutap1.ListBoSuuTap1;
import com.example.mapfoodltdd.home.listprovince.ListProvince;

import java.util.ArrayList;
import java.util.List;

public class XemThemBSTActivity extends AppCompatActivity {

    GridView gridView;
    Context context;
    RelativeLayout gridviewdata;
    ArrayList<ListBoSuuTapModel> bstData;
    BoSuuTapGridAdapter bstAdapter;
    ListBoSuuTapModel bst1Model;
    ImageView back;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_xem_them_bst);

        back=(ImageView) findViewById(R.id.idbackbst);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });
        //getviews
        gridView = findViewById(R.id.gridviewbst);
        gridviewdata = (RelativeLayout) findViewById(R.id.gridbst);
        bstData = new ArrayList<>();

        //add Countries Data
        populateProductData();
        bstAdapter = new BoSuuTapGridAdapter(context,bstData);
        gridView.setAdapter(bstAdapter);
        registerForContextMenu(gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,bstData.get(position).getNamebst(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),GridItemBSTActivity.class);
                intent.putExtra("name",bstData.get(position).getNamebst());
                intent.putExtra("image",bstData.get(position).getImagebst());
                startActivity(intent);
            }
        });

    }

    public void openMainActivity(){
        Intent intent=new Intent(XemThemBSTActivity.this, HomeFragment.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }

    private void populateProductData() {

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(1);
        bst1Model.setNamebst("Máy điều hòa treo tường");
        bst1Model.setImagebst(R.drawable.bst1);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(2);
        bst1Model.setNamebst("Máy điều hòa Sky Airs");
        bst1Model.setImagebst(R.drawable.bst2);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(3);
        bst1Model.setNamebst("Máy điều hòa VRV");
        bst1Model.setImagebst(R.drawable.bst3);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(4);
        bst1Model.setNamebst("Máy điều hòa Multi");
        bst1Model.setImagebst(R.drawable.bst4);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(5);
        bst1Model.setNamebst("Máy lọc không khí");
        bst1Model.setImagebst(R.drawable.bst5);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(6);
        bst1Model.setNamebst("Máy điều hòa Packaged");
        bst1Model.setImagebst(R.drawable.bst6);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(7);
        bst1Model.setNamebst("Máy tắm nóng lạnh");
        bst1Model.setImagebst(R.drawable.bst7);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(8);
        bst1Model.setNamebst("Máy nước nóng lạnh");
        bst1Model.setImagebst(R.drawable.bst8);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(9);
        bst1Model.setNamebst("Tủ lạnh");
        bst1Model.setImagebst(R.drawable.bst9);
        bstData.add(bst1Model);

        bst1Model = new ListBoSuuTapModel();
        bst1Model.setId(10);
        bst1Model.setNamebst("Máy giặc");
        bst1Model.setImagebst(R.drawable.bst10);
        bstData.add(bst1Model);

    }
}