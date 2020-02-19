package com.example.mykuangjia.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V extends IBaseView, P extends IBasePersenter> extends Fragment implements IBaseView {

    protected P persenter;
    protected Context context;
    protected Activity activity;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getContext();
        activity = getActivity();
        unbinder = ButterKnife.bind(this,view);
        persenter = (P) createPersenter();
        if(persenter != null) persenter.attachView(this);
        initView();
        initData();
    }

    //获取子类的布局id
    protected abstract int getLayout();
    //初始化界面
    protected abstract void initView();
    //初始化数据
    protected abstract void initData();
    //创建p层
    protected abstract IBasePersenter createPersenter();



    @Override
    public void showTips(String msg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(persenter != null){
            persenter.detachView();
        }
        if(unbinder != null){
            unbinder.unbind();
        }
    }


    public abstract void itemClick(int position, BaseAdapter.BaseViewHolder holder);
}
