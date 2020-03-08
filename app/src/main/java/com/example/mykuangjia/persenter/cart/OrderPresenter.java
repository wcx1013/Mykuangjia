package com.example.mykuangjia.persenter.cart;

import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.shoppingcart.ShoppingConstact;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.OrderInfoBean;
import com.example.mykuangjia.utils.RxUtils;

public class OrderPresenter extends BasePersenter<ShoppingConstact.OrderView> implements ShoppingConstact.OrderPresenter {
    @Override
    public void getCartIndex() {

    }

    @Override
    public void getOrderList(int addressId, int couponId) {
        addSubscribe(HttpManager.getInstance().getShopApi().getOrderInfo(addressId,couponId)
                .compose(RxUtils.<OrderInfoBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<OrderInfoBean>(mView){

                    @Override
                    public void onNext(OrderInfoBean orderInfoBean) {
                        mView.getOrderListReturn(orderInfoBean);
                    }
                }));
    }
}
