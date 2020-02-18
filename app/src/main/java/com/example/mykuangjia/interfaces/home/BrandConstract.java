package com.example.mykuangjia.interfaces.home;

import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.BrandBean;
import com.example.mykuangjia.models.bean.BrandGoodsBean;

public interface BrandConstract {
    interface View extends IBaseView{
        void getBrandInfoReturn(BrandBean result);
        void getBrandGoodsReturn(BrandGoodsBean result);
    }
    interface Persenter extends IBasePersenter<View> {
        void getBrandInfo(String id);
        void getBrandGoods(String brandId,int page,int size);


    }
}
