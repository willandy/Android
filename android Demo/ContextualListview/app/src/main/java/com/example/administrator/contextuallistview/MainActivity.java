package com.example.administrator.contextuallistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private ListView listView;
    private String[] android_versions;
    List<String> list=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    List selections=new ArrayList();
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.tv);
        android_versions=getResources().getStringArray(R.array.android_versions);
        for(String item:android_versions){
            list.add(item);
        }
        adapter=new ArrayAdapter<String>(getBaseContext(),R.layout.support_simple_spinner_dropdown_item,list);
        listView.setAdapter(adapter);
        //多选模式
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        //多选模式监听事项
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int position, long l, boolean checked) {
                if(checked){
                    selections.add(list.get(position));
                    count++;
                    actionMode.setTitle(count+" selected");
                }else {
                    selections.remove(list.get(position));
                    count--;
                    actionMode.setTitle(count+" selected");
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                //获取当前菜单的对象；
                MenuInflater menuInflater=getMenuInflater();
                //菜单层次从一个指定的xml资源去填充
                menuInflater.inflate(R.menu.my_menu,//要加载的布局文件的ID;
                        menu);//要填充的菜单;
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.id_delete){
                    for(Object Item:selections){
                        String ITEM=Item.toString();
                        list.remove(ITEM);
                    }
                        adapter.notifyDataSetInvalidated();
                        actionMode.finish();
                    return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
               count=0;
                selections.clear();
            }
        });
    }
}
