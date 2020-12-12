package com.example.mapfoodltdd.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mapfoodltdd.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    LinearLayout ln;
    ArrayList<ThongBaoModel> thongbaoData;
    LayoutInflater layoutInflater;
    ThongBaoModel thongbaoModel;

    public CustomAdapter(Context context, ArrayList<ThongBaoModel> thongbaoData) {
        this.context = context;
        this.thongbaoData = thongbaoData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return thongbaoData.size();
    }

    @Override
    public Object getItem(int i) {
        return thongbaoData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return thongbaoData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.list_thongbao, null, true);
        }
        //link views
        ImageView avata = rowView.findViewById(R.id.avata);
        TextView tieude = rowView.findViewById(R.id.tieude);
        ImageView detail = rowView.findViewById(R.id.detail);


        thongbaoModel = thongbaoData.get(position);

        avata.setImageResource(thongbaoModel.getAvata());
        tieude.setText(thongbaoModel.getTieude());
        detail.setImageResource(thongbaoModel.getDetail());

        return rowView;
    }

//    public void RemoveItem(int position) {
//        profileData.remove(position);
//        notifyDataSetChanged();
//    }

}