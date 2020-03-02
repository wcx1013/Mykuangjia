package com.example.mykuangjia.interfaces.login;


import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.UserBean;

public interface LoginConstract {

    interface View extends IBaseView {
        void loginReturn(UserBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void login(String nickname, String password);
    }

}
