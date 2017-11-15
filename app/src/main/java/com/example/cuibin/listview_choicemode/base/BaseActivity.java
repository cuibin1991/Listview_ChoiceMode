package com.example.cuibin.listview_choicemode.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by cuibin on 17/11/6.
 */

public abstract class BaseActivity extends FragmentActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
        initListener();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public abstract void initView();

    public abstract void initListener();

    public abstract void initData();

    public abstract void progressClick(View v);

    @Override
    public void onClick(View v) {
        progressClick(v);
    }
}
