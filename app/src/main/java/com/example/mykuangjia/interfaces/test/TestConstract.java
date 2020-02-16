package com.example.mykuangjia.interfaces.test;


import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.ChaptersBean;

public interface TestConstract {

    interface View extends IBaseView {
        void getChaptersReturn(ChaptersBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getChapters();
    }

}
