package com.example.mykuangjia.interfaces;

public interface IBasePersenter <V extends IBaseView>{
    //关联v层
    void attachView(V view);
    //取消v层的关联
    void detachView();
}
