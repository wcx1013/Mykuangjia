package com.example.mykuangjia.models.api;


import com.example.mykuangjia.models.bean.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ShopApi {

    @GET("index")
    Flowable<IndexBean> getIndexData();

}
