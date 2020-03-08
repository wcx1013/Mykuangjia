package com.example.mykuangjia.ui.shoppingcart.activity;

import android.view.View;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.interfaces.shoppingcart.ShoppingConstact;
import com.example.mykuangjia.models.bean.CartBean;
import com.example.mykuangjia.models.bean.OrderInfoBean;
import com.example.mykuangjia.persenter.cart.OrderPresenter;
import com.example.mykuangjia.ui.shoppingcart.adapter.ShoppingAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;

public class OrderlnfoActivity extends BaseActivity<IBaseView, ShoppingConstact.OrderPresenter> implements
        ShoppingConstact.OrderView {

    private ArrayList<CartBean.DataBean.CartListBean> list;
    private ShoppingAdapter shoppingAdapter;
    private TextView mTxtNoaddressTips;
    private TextView mTxtName;
    private TextView mTxtPhone;
    private TextView mTxtDefault;
    private TextView mTxtAddress;
    private ConstraintLayout mLayoutAddress;
    private ConstraintLayout mLayoutAddressInfo;
    private TextView mTxtCouponNums;
    private ConstraintLayout mLayoutCoupon;
    private TextView mTxtTotalPrice;
    private TextView mTxtFreight;
    private TextView mTxtCouponPrice;
    private ConstraintLayout mLayoutGoodsInfo;
    private RecyclerView mRecyGoodList;
    private ConstraintLayout mLayoutGoodList;
    private TextView mTxtPay;
    private RecyclerView mOrderRecy;
    private ConstraintLayout mLayoutPay;
    int addressId, couponId = 0; //地址ID+优惠券ID

    @Override
    protected int getLayout() {
        return R.layout.activity_orderinfo;

    }

    @Override
    protected void initView() {
        mTxtNoaddressTips = findViewById(R.id.txt_noaddress_tips);
        mTxtName = findViewById(R.id.txt_name);
        mTxtPhone = findViewById(R.id.txt_phone);
        mTxtDefault = findViewById(R.id.txt_default);
        mTxtAddress = findViewById(R.id.txt_address);
        mLayoutAddress = findViewById(R.id.layout_address);
        mLayoutAddressInfo = findViewById(R.id.layout_addressInfo);
        mTxtCouponNums = findViewById(R.id.txt_couponNums);
        mLayoutCoupon = findViewById(R.id.layout_coupon);
        mTxtTotalPrice = findViewById(R.id.txt_totalPrice);
        mTxtFreight = findViewById(R.id.txt_freight);
        mTxtCouponPrice = findViewById(R.id.txt_couponPrice);
        mLayoutGoodsInfo = findViewById(R.id.layout_goods_info);
        mRecyGoodList = findViewById(R.id.recy_goodList);
        mLayoutGoodList = findViewById(R.id.layout_goodList);
        mTxtPay = findViewById(R.id.txt_pay);
        mOrderRecy = findViewById(R.id.order_recy);
        mLayoutPay = findViewById(R.id.layout_pay);


        list = new ArrayList<>();
        shoppingAdapter = new ShoppingAdapter(list, OrderlnfoActivity.this);
        mOrderRecy.setLayoutManager(new LinearLayoutManager(this));
        mOrderRecy.setAdapter(shoppingAdapter);





    }

    @Override
    protected void initData() {
        persenter.getCartIndex();
        persenter.getOrderList(addressId,couponId);
    }

    @Override
    protected ShoppingConstact.OrderPresenter createPersenter() {
        return new OrderPresenter();
    }

    @Override
    public void getCartIndexReturn(CartBean result) {
        shoppingAdapter.updata(result.getData().getCartList());
    }

    @Override
    public void getOrderListReturn(OrderInfoBean result) {
        //刷新地址
        updateAddress(result.getData().getCheckedAddress());

        //刷新优惠券
        updateCoupon(result.getData().getCouponList());

        updateOrderInfo(result.getData());

        updateGoodList(result.getData().getCheckedGoodsList());
    }
    @OnClick({R.id.txt_noaddress_tips, R.id.layout_address, R.id.layout_coupon, R.id.txt_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_noaddress_tips:
                break;
            case R.id.layout_address:
                break;
            case R.id.layout_coupon:
                break;
            case R.id.txt_pay:
                break;
        }
    }
    //刷新地址
    private void updateAddress(OrderInfoBean.DataBean.CheckedAddressBean checkedAddress){

    }

    //刷新优惠券
    private void updateCoupon(List<OrderInfoBean.DataBean.CouponListBean> couponList){

    }

    //刷新商品信息
    private void updateOrderInfo(OrderInfoBean.DataBean data){

    }

    private void updateGoodList(List<OrderInfoBean.DataBean.CheckedGoodsListBean> checkedGoodsList){

    }
}
