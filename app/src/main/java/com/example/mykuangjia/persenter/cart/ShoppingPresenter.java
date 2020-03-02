package com.example.mykuangjia.persenter.cart;

import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.shoppingcart.ShoppingConstact;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.CartBean;
import com.example.mykuangjia.utils.RxUtils;

public class ShoppingPresenter extends BasePersenter<ShoppingConstact.View>
    implements ShoppingConstact.Presenter{
    @Override
    public void getCartIndex() {
        addSubscribe(HttpManager.getInstance().getShopApi().getCartIndex()
        .compose(RxUtils.rxScheduler()).subscribeWith(new CommonSubscriber<CartBean>(mView) {
                    @Override
                    public void onNext(CartBean cartBean) {
                        mView.getCartIndexReturn(cartBean);
                    }
                }));
    }
}
