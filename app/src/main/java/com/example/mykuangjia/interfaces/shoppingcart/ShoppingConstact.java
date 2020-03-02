package com.example.mykuangjia.interfaces.shoppingcart;

import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.CartBean;

public interface ShoppingConstact {
    interface View extends IBaseView{
        void getCartIndexReturn(CartBean result);
    }
    interface Presenter extends IBasePersenter<View> {
        void getCartIndex();
    }


}
