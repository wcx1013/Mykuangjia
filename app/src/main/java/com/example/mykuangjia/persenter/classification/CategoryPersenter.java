package com.example.mykuangjia.persenter.classification;

import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.classification.CategoryConstract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.CategoryListBean;
import com.example.mykuangjia.models.bean.CategoryTabBean;
import com.example.mykuangjia.utils.RxUtils;

public class CategoryPersenter extends BasePersenter<CategoryConstract.View>
        implements CategoryConstract.Persenter{
    @Override
    public void getCategoryTab(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getCategoryTab(id)
                .compose(RxUtils.<CategoryTabBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CategoryTabBean>(mView){
                    @Override
                    public void onNext(CategoryTabBean categoryTabBean) {
                        mView.getCategoryTabReturn(categoryTabBean);
                    }
                }));
    }

    @Override
    public void getGoodsList(int categoryId, int page, int size) {
        addSubscribe(HttpManager.getInstance().getShopApi().getCategoryList(categoryId, page, size)
                .compose(RxUtils.<CategoryListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CategoryListBean>(mView){
                    @Override
                    public void onNext(CategoryListBean categoryListBean) {
                        mView.getGoodsListReturn(categoryListBean);
                    }
                }));
    }
}
