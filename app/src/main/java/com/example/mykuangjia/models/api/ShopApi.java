package com.example.mykuangjia.models.api;


import com.example.mykuangjia.models.bean.AddressBean;
import com.example.mykuangjia.models.bean.AdressSaveBean;
import com.example.mykuangjia.models.bean.BrandBean;
import com.example.mykuangjia.models.bean.BrandDetialBean;
import com.example.mykuangjia.models.bean.BrandGoodsBean;
import com.example.mykuangjia.models.bean.CartBean;
import com.example.mykuangjia.models.bean.CatalogListBean;
import com.example.mykuangjia.models.bean.CatalogTabBean;
import com.example.mykuangjia.models.bean.CategoryListBean;
import com.example.mykuangjia.models.bean.CategoryTabBean;
import com.example.mykuangjia.models.bean.IndexBean;
import com.example.mykuangjia.models.bean.NewsDetailBean;
import com.example.mykuangjia.models.bean.OrderInfoBean;
import com.example.mykuangjia.models.bean.RegionBean;
import com.example.mykuangjia.models.bean.RelatedBean;
import com.example.mykuangjia.models.bean.TopicListBean;
import com.example.mykuangjia.models.bean.UserBean;
import com.example.mykuangjia.models.bean.VerifyBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShopApi {

    @GET("index")//专题页面
    Flowable<TopicListBean> getTopicList();
    @GET("index")
    Flowable<IndexBean> getIndexData();
    @GET("brand/detail")//品牌直供的详情页数据接口
    Flowable<BrandBean> getBrandInfo(@Query("id") String id);
    @GET("goods/list")//品牌直供详情的商品列表数据接口
    Flowable<BrandGoodsBean> getBrandGoods(@Query("brandId") String brandId, @Query("page") int page, @Query("size") int size);
    //获取分类Tab数据的接口goods/category { id: this.data.id }
    @GET("goods/category")
    Flowable<CategoryTabBean> getCategoryTab(@Query("id") int id);
    @GET("goods/hot")
    Flowable<NewsDetailBean> getNewsDetailBean();
    //商品分类列表数据goods/list{categoryId: that.data.id, page: that.data.page, size: that.data.size}
    @GET("goods/list")
    Flowable<CategoryListBean> getCategoryList(@Query("categoryId") int categoryId, @Query("page") int page, @Query("size") int size);
    //获取分类导航数据接口
    @GET("catalog/index")
    Flowable<CatalogTabBean> getCatalogTabData();
    //获取列表选中的数据
    @GET("catalog/current")
    Flowable<CatalogListBean> getCatalogList(@Query("id") int id);
    //商品购买页面的数据接口
    @GET("goods/detail")
    Flowable<RelatedBean> getRelatedData(@Query("id") int id);
    //获取购物车的数据
    @GET("cart/index")
    Flowable<CartBean> getCartIndex();
    //登录
    @POST("auth/login")
    Flowable<UserBean> login(@Field("nickname") String nickname, @Field("password") String password);
    //验证码
    @GET("auth/verify")
    Flowable<VerifyBean> getVerify();
    //下单前的订单确认  地址ID+优惠券ID
    @GET("cart/checkout")
    Flowable<OrderInfoBean> getOrderInfo(@Query("addressId") int addressId, @Query("couponId") int couponId);
    @GET("/brand/list")
    Flowable<BrandDetialBean> getBrandDetailBean(@Query("page") int page, @Query("size") int size);
    //新品，首发，居家等商品购买页的RecyclerView数据
    //地址列表
    @GET("address/list")
    Flowable<AddressBean> getAddress();

    //保存地址
    @POST("address/save")
    @FormUrlEncoded
    Flowable<AdressSaveBean> saveAdress(@FieldMap Map adressMap);

    //获取省市区的数据
    @GET("region/list?parentId=39")
    Flowable<RegionBean> getRegion(@Query("parentId") int parentId);

}
