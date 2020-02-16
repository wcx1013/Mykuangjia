package com.example.mykuangjia.ui.home;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseFragment;
import com.example.mykuangjia.interfaces.home.HomeConstract;
import com.example.mykuangjia.models.bean.IndexBean;
import com.example.mykuangjia.persenter.home.HomePersenter;

public class HomeFragment extends BaseFragment<HomeConstract.Persenter> implements HomeConstract.View {
    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.getHomeData();
    }

    @Override
    protected HomeConstract.Persenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void getHomeDataReturn(IndexBean result) {

    }
}
