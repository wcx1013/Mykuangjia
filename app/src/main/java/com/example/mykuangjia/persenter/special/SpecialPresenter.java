package com.example.mykuangjia.persenter.special;

import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.special.SpecialConstract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.TopicListBean;
import com.example.mykuangjia.utils.RxUtils;

public class SpecialPresenter extends BasePersenter<SpecialConstract.View> implements
        SpecialConstract.Persenter {
    @Override
    public void getTopic() {
        addSubscribe(HttpManager.getInstance().getShopApi().getTopicList()
        .compose(RxUtils.<TopicListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TopicListBean>(mView) {
                    @Override
                    public void onNext(TopicListBean topicListBean) {
                        mView.getSpecial(topicListBean);
                    }
                }));
    }
}
