package com.example.mykuangjia.interfaces.home;


import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.IndexBean;

public interface HomeConstract {

    interface View extends IBaseView {
        void getHomeDataReturn(IndexBean result);

    }

    interface Persenter extends IBasePersenter<View> {
        void getHomeData();
    }

}
