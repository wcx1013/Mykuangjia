package com.example.mykuangjia.persenter.login;


import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.login.RegisterConstract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.VerifyBean;
import com.example.mykuangjia.utils.RxUtils;

public class RegisterPersenter extends BasePersenter<RegisterConstract.View> implements RegisterConstract.Persenter {
    @Override
    public void getVerify() {
        addSubscribe(HttpManager.getInstance().getShopApi().getVerify()
        .compose(RxUtils.<VerifyBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<VerifyBean>(mView){

            @Override
            public void onNext(VerifyBean verifyBean) {
                mView.getVerifyReturn(verifyBean);
            }
        }));
    }

}
