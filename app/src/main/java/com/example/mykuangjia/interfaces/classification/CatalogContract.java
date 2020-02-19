package com.example.mykuangjia.interfaces.classification;


import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.CatalogListBean;
import com.example.mykuangjia.models.bean.CatalogTabBean;

/**
 * 分类相关接口
 */
public interface CatalogContract {

    interface View extends IBaseView {
        //定义用来接收获取分类Tab数据返回的方法
        void getCatalogTabDataReturn(CatalogTabBean result);
        //获取指定的列表数据
        void getCatalogListReturn(CatalogListBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //加载分类Tab数据
        void getCatalogTabData();
        //获取列表数据
        void getCatalogList(int id);
    }

}
