package com.example.administrator.navigationdemo.models;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.navigationdemo.R;

/**
 * Created by Administrator on 2017/11/19/019.
 */
public class Tab3Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.tab3fragment,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
