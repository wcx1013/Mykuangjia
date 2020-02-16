package com.example.mykuangjia.models.api;


import com.example.mykuangjia.models.bean.ChaptersBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface WanApi {

    @GET("wxarticle/chapters/json")
    Flowable<ChaptersBean> getChapters();


}
