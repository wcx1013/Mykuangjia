package com.example.mykuangjia.interfaces.special;

import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.models.bean.TopicListBean;

public interface SpecialConstract {
    interface View extends IBaseView{
        void getSpecial(TopicListBean result);
    }
    interface Persenter extends IBasePersenter<View>{
        void getTopic();
    }
}
