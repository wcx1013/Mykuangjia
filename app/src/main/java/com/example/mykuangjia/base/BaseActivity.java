package com.example.mykuangjia.base;

import android.os.Bundle;

import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends IBasePersenter> extends AppCompatActivity implements IBaseView {
    protected  P persenter;
    Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        persenter=createPersenter();
        if(persenter!=null){
            persenter.attachView(this);
        }
        initData();

    }
    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P createPersenter();

    @Override
    public void showTips(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(persenter!=null){
            persenter.detachView();
        }
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}
