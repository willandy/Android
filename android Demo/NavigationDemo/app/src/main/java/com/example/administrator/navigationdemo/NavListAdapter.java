package com.example.administrator.navigationdemo;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15/015.
 */
public class NavListAdapter extends ArrayAdapter<NavItem> {
   Context context;
    int resLayout;
    List<NavItem> listNavItems;

    public NavListAdapter(Context context, int resLayout, List<NavItem> listNavItems) {
        super(context, resLayout,listNavItems);
        this.context=context;
        this.resLayout=resLayout;
        this.listNavItems=listNavItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View v=View.inflate(context,resLayout,null);
        TextView tvTitle=v.findViewById(R.id.title);
        TextView tvSubTitle=v.findViewById(R.id.subtitle);
        ImageView navIcon=v.findViewById(R.id.nav_icon);

        NavItem navItem=listNavItems.get(position);

        tvTitle.setText(navItem.getTitle());
        tvSubTitle.setText(navItem.getSubTitle());
        navIcon.setImageResource(navItem.getResIcon());

        return v;
    }
}
