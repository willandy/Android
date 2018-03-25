package com.example.administrator.navigationdemo;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.example.administrator.navigationdemo.models.Tab1Fragment;
import com.example.administrator.navigationdemo.models.Tab2Fragment;
import com.example.administrator.navigationdemo.models.Tab3Fragment;

import java.util.List;
import java.util.Vector;

/**
 * Created by Administrator on 2017/11/15/015.
 */
public class Home extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_home,container,false);

        return v;
    }


}
