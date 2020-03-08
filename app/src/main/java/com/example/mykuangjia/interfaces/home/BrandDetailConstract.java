package com.example.mykuangjia.interfaces.home;


import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.BrandDetialBean;

public interface BrandDetailConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getBrandDetailReturn(BrandDetialBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getBrandDetail(int page, int size);
    }
}
