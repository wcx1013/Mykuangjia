package com.example.mykuangjia.persenter.cart;


import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.shoppingcart.ShoppingConstact;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.AddressBean;
import com.example.mykuangjia.utils.RxUtils;

public class AdressPresenter extends BasePersenter<ShoppingConstact.AdressView> implements ShoppingConstact.AdressPresenter {

    @Override
    public void getAdressList() {
        addSubscribe(HttpManager.getInstance().getShopApi().getAddress()
        .compose(RxUtils.<AddressBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<AddressBean>(mView){

            @Override
            public void onNext(AddressBean addressBean) {
                mView.getAdressListReturn(addressBean);
            }
        }));
    }
}
