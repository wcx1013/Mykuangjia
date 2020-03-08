package com.example.mykuangjia.persenter.home;


import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.home.BrandDetailConstract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.BrandDetialBean;
import com.example.mykuangjia.utils.RxUtils;

public class BrandDetailPersenter extends BasePersenter<BrandDetailConstract.View> implements BrandDetailConstract.Persenter {
    @Override
    public void getBrandDetail(int page,int sieze) {
        addSubscribe(HttpManager.getInstance().getShopApi().getBrandDetailBean(page,sieze)
                .compose(RxUtils.<BrandDetialBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandDetialBean>(mView){

                    @Override
                    public void onNext(BrandDetialBean brandDetialBean) {
                        mView.getBrandDetailReturn(brandDetialBean);
                    }
                }));
    }
}
