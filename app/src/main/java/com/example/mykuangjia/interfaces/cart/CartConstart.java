package com.example.mykuangjia.interfaces.cart;


import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.RelatedBean;

public interface CartConstart {

    interface View extends IBaseView {
        void getRelatedDataReturn(RelatedBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getRelatedData(int id);
    }

}
