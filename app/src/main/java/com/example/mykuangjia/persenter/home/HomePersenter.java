package com.example.mykuangjia.persenter.home;

import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.home.HomeConstract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.IndexBean;
import com.example.mykuangjia.utils.RxUtils;

public class HomePersenter  extends BasePersenter<HomeConstract.View>
        implements HomeConstract.Persenter  {
    //获取主页的具体实现
    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){

                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.getHomeDataReturn(indexBean);
                    }
                }));
    }
}
