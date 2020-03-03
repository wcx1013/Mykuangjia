package com.example.mykuangjia.persenter.login;


import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.login.LoginConstract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.UserBean;
import com.example.mykuangjia.utils.RxUtils;

public class LoginPersenter extends BasePersenter<LoginConstract.View> implements LoginConstract.Persenter {
    @Override
    public void login(String nickname, String password) {
        addSubscribe(HttpManager.getInstance().getShopApi().login(nickname,password)
        .compose(RxUtils.<UserBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<UserBean>(mView){

            @Override
            public void onNext(UserBean userBean) {
                if(userBean.getErrno() == 0){
                    mView.loginReturn(userBean);
                }else{
                    mView.showTips(userBean.getErrmsg());
                }
            }
        }));
    }
}
