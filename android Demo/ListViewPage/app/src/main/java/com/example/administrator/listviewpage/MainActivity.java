package com.example.administrator.listviewpage;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Vector;

import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener{
   private ListView listView;
    private Vector<News> news=new Vector<>();
    private int index=1;
    private MyAdapter myAdapter;
    private static final int DATA_UPDATE=0x1;//数据更新完成后的标记
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView5);
        listView.setOnScrollListener(this);//滚动注册
        View footerView=getLayoutInflater().inflate(R.layout.loading,null);
        listView.addFooterView(footerView);//吧加载字样放在底部
        initData();
        myAdapter=new MyAdapter();
        listView.setAdapter(myAdapter);
    }

    private void initData(){
        for(int i=0;i<15;i++){
            News n=new News();
            n.title="title-"+index;
            n.content="content-"+index;
            index++;
            news.add(n);
        }
    }

    private int visibleLastIndex;//用来可显示的最后一条数据的索引
    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        //让滚动停止并且到最底下的时候
        if(scrollState== AbsListView.OnScrollListener.SCROLL_STATE_IDLE && myAdapter.getCount()==visibleLastIndex){
              new LoadDataThread().start();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
         visibleLastIndex=firstVisibleItem+visibleItemCount-1;//减一是因为最后有一个正在加载中的字样
    }

    //线程之间通讯的机制,接到子线程发送的标签后，进行数据更新
    private Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case DATA_UPDATE:
                   myAdapter.notifyDataSetChanged();
                   break;
           }
        }
    };

    //模拟加载数据：编写线程用来增加数据:数据加载完成后，发送消息标签给主线程
    class LoadDataThread extends Thread{
        @Override
        public void run() {
            initData();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //myAdapter.notifyDataSetInvalidated();//注意：子线程调用主线程会报错，只能通知主线程
            //给通过handler给主线程发送一个消息标记
            handler.sendEmptyMessage(DATA_UPDATE);
        }
    }

    //自定义适配器
     class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return news.size();
        }

        @Override
        public Object getItem(int position) {
            return news.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder vh;
            if(view==null){
                view=getLayoutInflater().inflate(R.layout.list_item6,null);
                vh=new ViewHolder();
                vh.tv_title=view.findViewById(R.id.textView_title);
                vh.tv_content=view.findViewById(R.id.textView_content);
                view.setTag(vh);
            }else{
                vh= (ViewHolder) view.getTag();
            }
            News n=news.get(position);
            vh.tv_title.setText(n.title);
            vh.tv_content.setText(n.content);
            return view;
        }

         class ViewHolder{
             TextView tv_title;
             TextView tv_content;
         }


    }


}
