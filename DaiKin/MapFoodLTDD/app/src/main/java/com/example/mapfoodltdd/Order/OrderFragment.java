package com.example.mapfoodltdd.Order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mapfoodltdd.Order.Adapter.SectionPagerAdapter;
import com.example.mapfoodltdd.Order.Tab.DangDenFragment;
import com.example.mapfoodltdd.Order.Tab.DonNhapFragment;
import com.example.mapfoodltdd.Order.Tab.Lichsu.LichSuFragment;
import com.example.mapfoodltdd.R;
import com.google.android.material.tabs.TabLayout;

public class OrderFragment extends Fragment {

    View myFragment;
    ViewPager viewPager;
    TabLayout tabLayout;


    public OrderFragment() {
        // Required empty public constructor
    }

    public static OrderFragment getInstance() {
        return new OrderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_order, container, false);
        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);
        return myFragment;
    }
    //Call onActivity Create method

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new DangDenFragment(), "Dịch Vụ");
        adapter.addFragment(new DonNhapFragment(), "Phụ kiện");
        viewPager.setAdapter(adapter);
    }
}