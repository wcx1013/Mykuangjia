package com.example.mykuangjia.persenter.home;


import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.home.HotConstract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.NewsDetailBean;
import com.example.mykuangjia.utils.RxUtils;

public class HotPersenter extends BasePersenter<HotConstract.View> implements HotConstract.Persenter {
    @Override
    public void getNewsDetailBean() {
        addSubscribe(HttpManager.getInstance().getShopApi().getNewsDetailBean()
                .compose(RxUtils.<NewsDetailBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<NewsDetailBean>(mView){

                    @Override
                    public void onNext(NewsDetailBean newsDetailBean) {
                        mView.getNewsDetailReturn(newsDetailBean);
                    }
                }));
    }
}
