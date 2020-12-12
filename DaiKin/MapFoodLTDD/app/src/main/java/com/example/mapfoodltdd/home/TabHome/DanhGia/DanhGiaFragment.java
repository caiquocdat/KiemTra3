package com.example.mapfoodltdd.home.TabHome.DanhGia;

import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.home.TabHome.BanChay.CustomAdapterBanChay;
import com.example.mapfoodltdd.home.TabHome.BanChay.MonAnBanChayModel;

import java.util.ArrayList;

public class DanhGiaFragment extends Fragment {

    private ListView listdanhgia;
    Context context;
    private ConstraintLayout reladanhgia;
    private ArrayList<MonAnDanhGiaModel> monanDGData;
    private CustomAdapterDanhGia customAdapter;
    private MonAnDanhGiaModel monAnDanhGiaModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context=getActivity();
        View root = inflater.inflate(R.layout.fragment_danhgia, container, false);
        listdanhgia = root.findViewById(R.id.listdanhgia);
        reladanhgia= root.findViewById(R.id.reladanhgia);
        monanDGData = new ArrayList<>();

        listdanhgiaData();
        customAdapter = new CustomAdapterDanhGia(context, monanDGData);
        listdanhgia.setAdapter(customAdapter);
        registerForContextMenu(listdanhgia);
        listdanhgia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, monanDGData.get(position).getIdtenmonandg(), Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
    private void listdanhgiaData() {

        monAnDanhGiaModel=new MonAnDanhGiaModel();
        monAnDanhGiaModel.setId(1);
        monAnDanhGiaModel.setIdimgdg(R.drawable.quan1);
        monAnDanhGiaModel.setIdtenmonandg("Bánh canh đường ray-Lê Độ");
        monAnDanhGiaModel.setIddiachidg("K77A/09 Lê Độ, Đà Nẵng");
        monAnDanhGiaModel.setIdgiadg("31.000đ");
        monanDGData.add(monAnDanhGiaModel);

        monAnDanhGiaModel=new MonAnDanhGiaModel();
        monAnDanhGiaModel.setId(2);
        monAnDanhGiaModel.setIdimgdg(R.drawable.quan2);
        monAnDanhGiaModel.setIdtenmonandg("Bánh canh đường ray-Lê Độ");
        monAnDanhGiaModel.setIddiachidg("K77A/09 Lê Độ, Đà Nẵng");
        monAnDanhGiaModel.setIdgiadg("31.000đ");
        monanDGData.add(monAnDanhGiaModel);

        monAnDanhGiaModel=new MonAnDanhGiaModel();
        monAnDanhGiaModel.setId(3);
        monAnDanhGiaModel.setIdimgdg(R.drawable.quan3);
        monAnDanhGiaModel.setIdtenmonandg("Bánh canh đường ray-Lê Độ");
        monAnDanhGiaModel.setIddiachidg("K77A/09 Lê Độ, Đà Nẵng");
        monAnDanhGiaModel.setIdgiadg("31.000đ");
        monanDGData.add(monAnDanhGiaModel);

        monAnDanhGiaModel=new MonAnDanhGiaModel();
        monAnDanhGiaModel.setId(4);
        monAnDanhGiaModel.setIdimgdg(R.drawable.quan4);
        monAnDanhGiaModel.setIdtenmonandg("Bánh canh đường ray-Lê Độ");
        monAnDanhGiaModel.setIddiachidg("K77A/09 Lê Độ, Đà Nẵng");
        monAnDanhGiaModel.setIdgiadg("31.000đ");
        monanDGData.add(monAnDanhGiaModel);

        monAnDanhGiaModel=new MonAnDanhGiaModel();
        monAnDanhGiaModel.setId(5);
        monAnDanhGiaModel.setIdimgdg(R.drawable.quan1);
        monAnDanhGiaModel.setIdtenmonandg("Bánh canh đường ray-Lê Độ");
        monAnDanhGiaModel.setIddiachidg("K77A/09 Lê Độ, Đà Nẵng");
        monAnDanhGiaModel.setIdgiadg("31.000đ");
        monanDGData.add(monAnDanhGiaModel);

        monAnDanhGiaModel=new MonAnDanhGiaModel();
        monAnDanhGiaModel.setId(6);
        monAnDanhGiaModel.setIdimgdg(R.drawable.quan2);
        monAnDanhGiaModel.setIdtenmonandg("Bánh canh đường ray-Lê Độ");
        monAnDanhGiaModel.setIddiachidg("K77A/09 Lê Độ, Đà Nẵng");
        monAnDanhGiaModel.setIdgiadg("31.000đ");
        monanDGData.add(monAnDanhGiaModel);
    }

}