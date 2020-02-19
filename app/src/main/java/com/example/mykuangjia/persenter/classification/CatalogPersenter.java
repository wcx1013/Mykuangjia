package com.example.mykuangjia.persenter.classification;


import com.example.mykuangjia.base.BasePersenter;
import com.example.mykuangjia.common.CommonSubscriber;
import com.example.mykuangjia.interfaces.classification.CatalogContract;
import com.example.mykuangjia.models.HttpManager;
import com.example.mykuangjia.models.bean.CatalogListBean;
import com.example.mykuangjia.models.bean.CatalogTabBean;
import com.example.mykuangjia.utils.RxUtils;

public class CatalogPersenter extends BasePersenter<CatalogContract.View> implements CatalogContract.Persenter {

    //获取分类列表数据
    @Override
    public void getCatalogTabData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getCatalogTabData()
        .compose(RxUtils.<CatalogTabBean>rxScheduler())
        .subscribeWith(new CommonSubscriber<CatalogTabBean>(mView){

            @Override
            public void onNext(CatalogTabBean catalogTabBean) {
                if(catalogTabBean.getErrno() == 0){
                    mView.getCatalogTabDataReturn(catalogTabBean);
                }else{
                    mView.showTips(catalogTabBean.getErrmsg());
                }
            }
        }));
    }

    //获取指定列表的数据
    @Override
    public void getCatalogList(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getCatalogList(id)
                .compose(RxUtils.<CatalogListBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<CatalogListBean>(mView){

                    @Override
                    public void onNext(CatalogListBean catalogListBean) {
                        if(catalogListBean.getErrno() == 0){
                            mView.getCatalogListReturn(catalogListBean);
                        }else{
                            mView.showTips(catalogListBean.getErrmsg());
                        }
                    }
                }));
    }
}
