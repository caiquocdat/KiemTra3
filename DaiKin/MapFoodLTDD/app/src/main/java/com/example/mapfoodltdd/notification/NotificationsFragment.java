package com.example.mapfoodltdd.notification;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.mapfoodltdd.R;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private ListView listView, listView2;
    Context context;
    private ConstraintLayout rela, rela2;
    private ArrayList<ThongBaoModel> thongbaoData;
    private CustomAdapter customAdapter;
    private ThongBaoModel thongbaoModel;

    private ArrayList<TinhTrangModel> tinhtrangData;
    private CustomAdapter2 customAdapter2;
    private TinhTrangModel tinhtrangModel;

    //1
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context=getActivity();
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        listView = root.findViewById(R.id.listView);
        rela = root.findViewById(R.id.rela);
        thongbaoData = new ArrayList<>();

        listView2 = root.findViewById(R.id.listView2);
        rela2 = root.findViewById(R.id.rela2);
        tinhtrangData = new ArrayList<>();

        //add Countries Data

        listtinhtrang();
        customAdapter = new CustomAdapter(context, thongbaoData);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, thongbaoData.get(position).getTieude(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),name[position], Toast.LENGTH_LONG).show();
//                 Intent intent = new Intent(getApplicationContext(), OpenThongBao.class);
//                intent.putExtra("image", image[position]);
//                intent.putExtra("name", name[position]);
//                startActivity(intent);
            }
        });
        customAdapter2 = new CustomAdapter2(context, tinhtrangData);
        listView2.setAdapter(customAdapter2);
        registerForContextMenu(listView2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, tinhtrangData.get(position).getTieude2(), Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }


    private void listtinhtrang() {

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(1);
        tinhtrangModel.setAvata2(R.drawable.ic_baseline_fiber_new_24);
        tinhtrangModel.setTieude2("Nhanh tay nhận ưu đãi cuối tháng 11");

        tinhtrangModel.setTime("24/12/2020 13:04");
        tinhtrangData.add(tinhtrangModel);

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(2);
        tinhtrangModel.setAvata2(R.drawable.ic_baseline_fiber_new_24);
        tinhtrangModel.setTieude2("News");
        tinhtrangModel.setTime("22/12/2020 9:15");
        tinhtrangData.add(tinhtrangModel);

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(3);
        tinhtrangModel.setAvata2(R.drawable.ic_baseline_fiber_new_24);
        tinhtrangModel.setTieude2("Tháng 11 book bảo trì có ngay quà hay");
        tinhtrangModel.setTime("17/12/2020 10:20");
        tinhtrangData.add(tinhtrangModel);

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(4);
        tinhtrangModel.setAvata2(R.drawable.ic_baseline_fiber_new_24);
        tinhtrangModel.setTieude2("Thời tiết nồm rồi, bật ngay chết độ Dry khử ấm");
        tinhtrangModel.setTime("11/12/2020 18:20");
        tinhtrangData.add(tinhtrangModel);

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(5);
        tinhtrangModel.setAvata2(R.drawable.ic_baseline_fiber_new_24);
        tinhtrangModel.setTieude2("Mùa seal đã đến, đặt đồ cùng DAIKIN ngay!");
        tinhtrangModel.setTime("29/11/2020 18:20");
        tinhtrangData.add(tinhtrangModel);


        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(6);
        tinhtrangModel.setAvata2(R.drawable.ic_baseline_fiber_new_24);
        tinhtrangModel.setTieude2("Nóng quá nè, đặt máy lạnh ở DAIKIN nào.");
        tinhtrangModel.setTime("11/10/2020 18:20");
        tinhtrangData.add(tinhtrangModel);

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(7);
        tinhtrangModel.setAvata2(R.drawable.ic_baseline_fiber_new_24);
        tinhtrangModel.setTieude2("News");
        tinhtrangModel.setTime("10/10/2020 18:20");
        tinhtrangData.add(tinhtrangModel);
    }
}
