package com.example.administrator.floatingdemo;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    FloatingActionButton fab,fabTrai,fabPhai,fabTren,fabDuoi;
    Animation move_Trai,Move_Phai,Move_Tren,Move_Duoi,
            back_Trai,back_Phai,back_Tren,back_Duoi;
    boolean moveback=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab=findViewById(R.id.fab);
        fabTrai=findViewById(R.id.fab_Trai);
        fabPhai=findViewById(R.id.fab_Phai);
        fabTren=findViewById(R.id.fab_Tren);
        fabDuoi=findViewById(R.id.fab_Duoi);

        move_Trai= AnimationUtils.loadAnimation(this,R.anim.move_trai);
        Move_Phai=AnimationUtils.loadAnimation(this,R.anim.move_phai);
        Move_Tren=AnimationUtils.loadAnimation(this,R.anim.move_tren);
        Move_Duoi=AnimationUtils.loadAnimation(this,R.anim.move_duoi);

        back_Trai= AnimationUtils.loadAnimation(this,R.anim.back_trai);
        back_Phai=AnimationUtils.loadAnimation(this,R.anim.back_phai);
        back_Tren=AnimationUtils.loadAnimation(this,R.anim.back_tren);
        back_Duoi=AnimationUtils.loadAnimation(this,R.anim.back_duoi);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(moveback ==false){
                    Move();
                    moveback=true;
                }else{
                    Back();
                    moveback=false;
                }
            }
        });

        fabTrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"this is first.",Toast.LENGTH_LONG).show();
            }
        });

        fabPhai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"this is second.",Toast.LENGTH_LONG).show();
            }
        });
        fabTren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"this is third.",Toast.LENGTH_LONG).show();
            }
        });
        fabDuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"this is fouth.",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void Move(){
        FrameLayout.LayoutParams paramsTrai= (FrameLayout.LayoutParams) fabTrai.getLayoutParams();
        paramsTrai.rightMargin=(int)(fabTrai.getWidth()*1.7);
        fabTrai.setLayoutParams(paramsTrai);
        fabTrai.startAnimation(move_Trai);

        FrameLayout.LayoutParams paramsPhai= (FrameLayout.LayoutParams) fabPhai.getLayoutParams();
        paramsPhai.leftMargin=(int)(fabPhai.getWidth()*1.7);
        fabPhai.setLayoutParams(paramsPhai);
        fabPhai.startAnimation(Move_Phai);

        FrameLayout.LayoutParams paramsTren= (FrameLayout.LayoutParams) fabTren.getLayoutParams();
        paramsTren.bottomMargin=(int)(fabPhai.getWidth()*1.7);
        fabTren.setLayoutParams(paramsTren);
        fabTren.startAnimation(Move_Tren);

        FrameLayout.LayoutParams paramsDuoi= (FrameLayout.LayoutParams) fabDuoi.getLayoutParams();
        paramsDuoi.topMargin=(int)(fabDuoi.getWidth()*1.7);
        fabDuoi.setLayoutParams(paramsDuoi);
        fabDuoi.startAnimation(Move_Duoi);
    }

    private void Back(){
        FrameLayout.LayoutParams paramsTrai= (FrameLayout.LayoutParams) fabTrai.getLayoutParams();
        paramsTrai.rightMargin -=(int)(fabTrai.getWidth()*1.7);
        fabTrai.setLayoutParams(paramsTrai);
        fabTrai.startAnimation(back_Trai);

        FrameLayout.LayoutParams paramsPhai= (FrameLayout.LayoutParams) fabPhai.getLayoutParams();
        paramsPhai.leftMargin -=(int)(fabPhai.getWidth()*1.7);
        fabPhai.setLayoutParams(paramsPhai);
        fabPhai.startAnimation(back_Phai);

        FrameLayout.LayoutParams paramsTren= (FrameLayout.LayoutParams) fabTren.getLayoutParams();
        paramsTren.bottomMargin -=(int)(fabPhai.getWidth()*1.7);
        fabTren.setLayoutParams(paramsTren);
        fabTren.startAnimation(back_Tren);

        FrameLayout.LayoutParams paramsDuoi= (FrameLayout.LayoutParams) fabDuoi.getLayoutParams();
        paramsDuoi.topMargin -=(int)(fabDuoi.getWidth()*1.7);
        fabDuoi.setLayoutParams(paramsDuoi);
        fabDuoi.startAnimation(back_Duoi);
    }

}
