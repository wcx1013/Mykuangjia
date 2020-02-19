package com.example.mykuangjia.models.api;


import com.example.mykuangjia.models.bean.BrandBean;
import com.example.mykuangjia.models.bean.BrandGoodsBean;
import com.example.mykuangjia.models.bean.CatalogListBean;
import com.example.mykuangjia.models.bean.CatalogTabBean;
import com.example.mykuangjia.models.bean.CategoryListBean;
import com.example.mykuangjia.models.bean.CategoryTabBean;
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
    //获取分类Tab数据的接口goods/category { id: this.data.id }
    @GET("goods/category")
    Flowable<CategoryTabBean> getCategoryTab(@Query("id") int id);

    //商品分类列表数据goods/list{categoryId: that.data.id, page: that.data.page, size: that.data.size}
    @GET("goods/list")
    Flowable<CategoryListBean> getCategoryList(@Query("categoryId") int categoryId, @Query("page") int page, @Query("size") int size);
    //获取分类导航数据接口
    @GET("catalog/index")
    Flowable<CatalogTabBean> getCatalogTabData();
    //获取列表选中的数据
    @GET("catalog/current")
    Flowable<CatalogListBean> getCatalogList(@Query("id") int id);

}
