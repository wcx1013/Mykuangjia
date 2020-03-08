package com.example.mykuangjia.ui.home.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.interfaces.home.HotConstract;
import com.example.mykuangjia.models.bean.NewsDetailBean;
import com.example.mykuangjia.persenter.home.HotPersenter;

public class HotActivity extends BaseActivity<IBaseView, HotConstract.Persenter> implements HotConstract.View {
    private ImageView mHotBanner;
    private TextView mHotName;

    @Override
    protected int getLayout() {
        return R.layout.activity_hot;

    }

    @Override
    protected void initView() {
        mHotBanner = findViewById(R.id.hot_banner);
        mHotName = findViewById(R.id.hot_name);
    }

    @Override
    protected void initData() {
        persenter.getNewsDetailBean();
    }

    @Override
    protected HotConstract.Persenter createPersenter() {
        return new HotPersenter();
    }

    @Override
    public void getNewsDetailReturn(NewsDetailBean result) {
        updateBanner(result.getData().getBannerInfo().getImg_url(),result.getData().getBannerInfo().getName());
    }
    private void updateBanner(String url,String name) {
        Glide.with(this).load(url).into(mHotBanner);
        mHotName.setText(name);
    }
}
