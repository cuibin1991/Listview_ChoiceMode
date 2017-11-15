package com.example.cuibin.listview_choicemode.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cuibin.listview_choicemode.R;
import com.example.cuibin.listview_choicemode.adapter.PhoneSettingListAdapter;
import com.example.cuibin.listview_choicemode.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<String> list = new ArrayList<String>();
    private PhoneSettingListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.lv_phone_setting);
    }

    @Override
    public void initListener() {
        listView.setOnItemClickListener(this);
    }

    @Override
    public void initData() {
        list.add("111 号码一");
        list.add("222 号码二");
        list.add("333 号码三");
        list.add("444 号码四");
        adapter = new PhoneSettingListAdapter(MainActivity.this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void progressClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        saveCurrentPosition(position);
        adapter.notifyDataSetChanged();
    }

    private void saveCurrentPosition(int position){
        SharedPreferences preferences = getSharedPreferences("user" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("CurrentPosition" , position + "");
        editor.commit();
    }

}
