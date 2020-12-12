package com.example.mapfoodltdd.collections.tabchitietquananyeuthich.binhluan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mapfoodltdd.R;

import java.util.ArrayList;

public class BinhLuanAdapter extends BaseAdapter {

    Context context106;
    ArrayList<BinhLuanModel> binhluanData;
    LayoutInflater layoutInflater;
    BinhLuanModel binhluanModel;

    public BinhLuanAdapter(Context context, ArrayList<BinhLuanModel> binhluanData) {
        this.context106 = context;
        this.binhluanData = binhluanData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return binhluanData.size();
    }

    @Override
    public Object getItem(int i) {
        return binhluanData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return  binhluanData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView = view;
        if (rowView==null) {
            rowView = layoutInflater.inflate(R.layout.list_binhluan, null, true);
        }
        //link views
        ImageView avata = rowView.findViewById(R.id.avata);
        TextView ten= rowView.findViewById(R.id.ten);
        TextView time= rowView.findViewById(R.id.time);
        TextView danhgia= rowView.findViewById(R.id.danhgia);
        ImageView trasua = rowView.findViewById(R.id.trasua);


        binhluanModel= binhluanData.get(position);

        avata.setImageResource(binhluanModel.getAvata());
        ten.setText(binhluanModel.getTen());
        time.setText(binhluanModel.getTime());
        danhgia.setText(binhluanModel.getDanhgia());
        trasua.setImageResource(binhluanModel.getTrasua());


        return rowView;
    }
}