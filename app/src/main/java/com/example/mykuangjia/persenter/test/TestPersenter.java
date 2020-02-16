package com.example.mykuangjia.persenter.test;

import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.test.TestConstract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.ChaptersBean;
import com.example.mykuangjia.models.bean.IndexBean;
import com.example.mykuangjia.utils.RxUtils;

public class TestPersenter extends BasePersenter<TestConstract.View> implements  TestConstract.Persenter {
    @Override
    public void getChapters() {
        addSubscribe(HttpManager.getInstance().getWanApi()
                .getChapters().compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<ChaptersBean>(mView) {
            @Override
            public void onNext(ChaptersBean chaptersBean) {
                mView.getChaptersReturn(chaptersBean);
            }
        }));
    }
}














