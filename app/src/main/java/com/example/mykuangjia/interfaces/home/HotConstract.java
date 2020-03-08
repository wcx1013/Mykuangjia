package com.example.mykuangjia.interfaces.home;


import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.NewsDetailBean;

public interface HotConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getNewsDetailReturn(NewsDetailBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getNewsDetailBean();
    }
}
