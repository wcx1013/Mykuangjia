package com.example.mykuangjia.models.api;


import com.example.mykuangjia.models.bean.BrandBean;
import com.example.mykuangjia.models.bean.BrandGoodsBean;
import com.example.mykuangjia.models.bean.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShopApi {

    @GET("index")
    Flowable<IndexBean> getIndexData();
    @GET("brand/detail")//品牌直供的详情页数据接口
    Flowable<BrandBean> getBrandInfo(@Query("id") String id);
    @GET("goods/list")//品牌直供详情的商品列表数据接口
    Flowable<BrandGoodsBean> getBrandGoods(@Query("brandId") String brandId, @Query("page") int page, @Query("size") int size);


}
