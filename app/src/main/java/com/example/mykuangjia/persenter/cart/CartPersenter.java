package com.example.mykuangjia.persenter.cart;


import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.cart.CartConstart;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.RelatedBean;
import com.example.mykuangjia.utils.RxUtils;

public class CartPersenter extends BasePersenter<CartConstart.View> implements CartConstart.Persenter {

    //获取商品购买页面的数据
    @Override
    public void getRelatedData(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getRelatedData(id)
        .compose(RxUtils.<RelatedBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<RelatedBean>(mView){

            @Override
            public void onNext(RelatedBean relatedBean) {
                mView.getRelatedDataReturn(relatedBean);
            }
        }));
    }

}
