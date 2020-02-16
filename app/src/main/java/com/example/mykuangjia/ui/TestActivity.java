package com.example.mykuangjia.ui;

import android.util.Log;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.test.TestConstract;
import com.example.mykuangjia.models.bean.ChaptersBean;
import com.example.mykuangjia.persenter.test.TestPersenter;

public class TestActivity extends BaseActivity<TestConstract.Persenter> implements TestConstract.View {
    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.getChapters();
    }

    @Override
    protected TestConstract.Persenter createPersenter() {
        return new TestPersenter();
    }

    @Override
    public void getChaptersReturn(ChaptersBean result) {
        Log.i("Test",result.getData().toString());
    }
}
