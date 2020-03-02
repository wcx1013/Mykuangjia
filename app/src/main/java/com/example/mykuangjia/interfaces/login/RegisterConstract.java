package com.example.mykuangjia.interfaces.login;


import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.VerifyBean;

public interface RegisterConstract {

    interface View extends IBaseView {
        void getVerifyReturn(VerifyBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getVerify();
    }

}
