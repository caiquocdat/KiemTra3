package com.example.mapfoodltdd.Order.Tab.Lichsu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.notification.CustomAdapter;
import com.example.mapfoodltdd.notification.CustomAdapter2;
import com.example.mapfoodltdd.notification.ThongBaoModel;
import com.example.mapfoodltdd.notification.TinhTrangModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class LichSuFragment extends Fragment {

    TextView popuptatca,popupdichvu,lich;
    private ListView listView;
    Context context;
    private ConstraintLayout relalichsu;
    private ArrayList<MonAnModel> monanData;
    private CustomAdapterLichSu customAdapter;
    private MonAnModel monanModel;

    //1
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context=getActivity();
        View root = inflater.inflate(R.layout.fragment_lichsu, container, false);
        listView = root.findViewById(R.id.listlichsu);
        relalichsu = root.findViewById(R.id.relalichsu);
        monanData = new ArrayList<>();

        listlichsuData();
        customAdapter = new CustomAdapterLichSu(context, monanData);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, monanData.get(position).getIdmonan(), Toast.LENGTH_SHORT).show();
            }
        });

        lich=root.findViewById(R.id.lich);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dinhdangngay = new SimpleDateFormat("dd/MM/yyyy");
        lich.append(dinhdangngay.format(calendar.getTime()));
        popuptatca= root.findViewById(R.id.popuptatca);
        popuptatca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        showPopuptatca(view);
                    }
        });
        popupdichvu= root.findViewById(R.id.popupdichvu);
        popupdichvu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupdichvu(view);
            }
        });
        return root;
    }

    public void showPopuptatca(View v) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menutatcalichsu_order, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tatca:
                        Toast.makeText(getActivity().getApplicationContext(),"Tất cả",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.dahuy:
                        Toast.makeText(getActivity().getApplicationContext(),"Đã hủy",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.hoanthanh:
                        Toast.makeText(getActivity().getApplicationContext(),"Hoàn thành",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    public void showPopupdichvu(View v) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menudichvulichsu_order, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.thuoc:
                        Toast.makeText(getActivity().getApplicationContext(),"Thuốc",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.thucung:
                        Toast.makeText(getActivity().getApplicationContext(),"Thú cưng",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.giatui:
                        Toast.makeText(getActivity().getApplicationContext(),"Giặt ủi",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.giaohang:
                        Toast.makeText(getActivity().getApplicationContext(),"Giao hàng",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.datban:
                        Toast.makeText(getActivity().getApplicationContext(),"Đặt bàn",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.salon:
                        Toast.makeText(getActivity().getApplicationContext(),"Salon",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.giupviec:
                        Toast.makeText(getActivity().getApplicationContext(),"Giúp việc",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    private void listlichsuData() {

        monanModel=new MonAnModel();
        monanModel.setId(1);
        monanModel.setIdimglichsu(R.drawable.quan1);
        monanModel.setIdmonan("24100");
        monanModel.setIdtenmonan("Bánh canh đường ray-Lê Độ");
        monanModel.setIdlichlichsu("24/10/2020");
        monanModel.setIddiachilichsu("K77A/09 Lê Độ, Đà Nẵng");
        monanModel.setIdgialichsu("31.000đ");
        monanData.add(monanModel);

        monanModel=new MonAnModel();
        monanModel.setId(2);
        monanModel.setIdimglichsu(R.drawable.quan2);
        monanModel.setIdmonan("24101");
        monanModel.setIdtenmonan("Hủ tiếu Nam Vang");
        monanModel.setIdlichlichsu("26/10/2020");
        monanModel.setIddiachilichsu("K38/1 Bắc Đẩu, Đà Nẵng");
        monanModel.setIdgialichsu("25.000đ");
        monanData.add(monanModel);

        monanModel=new MonAnModel();
        monanModel.setId(3);
        monanModel.setIdimglichsu(R.drawable.quan3);
        monanModel.setIdmonan("24102");
        monanModel.setIdtenmonan("Chè Cô Hạnh");
        monanModel.setIdlichlichsu("02/11/2020");
        monanModel.setIddiachilichsu("80 Hải Phòng, Đà Nẵng");
        monanModel.setIdgialichsu("20.000đ");
        monanData.add(monanModel);

        monanModel=new MonAnModel();
        monanModel.setId(4);
        monanModel.setIdimglichsu(R.drawable.quan4);
        monanModel.setIdmonan("24103");
        monanModel.setIdtenmonan("Sữa chua nếp cẩm");
        monanModel.setIdlichlichsu("04/11/2020");
        monanModel.setIddiachilichsu("K121/4 Trần Cao Vân, Đà Nẵng");
        monanModel.setIdgialichsu("40.000đ");
        monanData.add(monanModel);

        monanModel=new MonAnModel();
        monanModel.setId(5);
        monanModel.setIdimglichsu(R.drawable.quan1);
        monanModel.setIdmonan("24104");
        monanModel.setIdtenmonan("Trà chanh Patit");
        monanModel.setIdlichlichsu("05/11/2020");
        monanModel.setIddiachilichsu("29 Thanh Thủy, Đà Nẵng");
        monanModel.setIdgialichsu("31.000đ");
        monanData.add(monanModel);

        monanModel=new MonAnModel();
        monanModel.setId(6);
        monanModel.setIdimglichsu(R.drawable.quan2);
        monanModel.setIdmonan("24105");
        monanModel.setIdtenmonan("Phở Hà Nội");
        monanModel.setIdlichlichsu("11/11/2020");
        monanModel.setIddiachilichsu("12 Đinh Tiên Hoàng, Đà Nẵng");
        monanModel.setIdgialichsu("45.000đ");
        monanData.add(monanModel);
    }
}
