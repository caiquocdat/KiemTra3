package com.example.mapfoodltdd.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.mapfoodltdd.Login;
import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.profile.ThongTinNguoiDung.ThongTinNguoiDung;

public class ProfileFragment extends Fragment {
    TextView diachi;
    Button dangxuat;
    ImageView ttcn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        dangxuat = root.findViewById(R.id.dangxuat);
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
        ttcn = root.findViewById(R.id.idttcn);
        ttcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThongTinCaNhan();
            }
        });

        return root;
    }

    public void openDiaChi(){
        Intent intent=new Intent(ProfileFragment.this.getActivity(), DiaChi.class);
        startActivity(intent);
    }

    public void openLogin(){
        Intent intent=new Intent(ProfileFragment.this.getActivity(), Login.class);
        startActivity(intent);
    }

    public void openThongTinCaNhan(){
        Intent intent=new Intent(ProfileFragment.this.getActivity(), ThongTinNguoiDung.class);
        startActivity(intent);
    }

}

