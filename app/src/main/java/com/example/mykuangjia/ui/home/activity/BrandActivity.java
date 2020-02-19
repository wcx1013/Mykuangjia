package com.example.mykuangjia.ui.home.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.home.BrandConstract;
import com.example.mykuangjia.models.bean.BrandBean;
import com.example.mykuangjia.models.bean.BrandGoodsBean;
import com.example.mykuangjia.persenter.home.BrandPersenter;

import java.util.ArrayList;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BrandActivity extends BaseActivity<BrandConstract.Persenter> implements BrandConstract.View {
    private ImageView mImgBack;
    private TextView mTxtTitle;
    private ImageView mImgBg;
    private TextView mTxtName;
    private ConstraintLayout mLayoutInfos;
    private TextView mTxtDes;
    private View mViewLine;
    private RecyclerView mRecyclerView;
    private ArrayList<BrandGoodsBean.DataBeanX.GoodsListBean> goodsListBeans;
    private BrandGoodsAdapter brandGoodsAdapter;
    private int brandld;

    @Override
    protected int getLayout() {
        return R.layout.activity_brand;

    }

    @Override
    protected void initView() {
        mImgBack = findViewById(R.id.img_back);
        mTxtTitle = findViewById(R.id.txt_title);
        mImgBg = findViewById(R.id.img_bg);
        mTxtName = findViewById(R.id.txt_name);
        mLayoutInfos = findViewById(R.id.layout_infos);
        mTxtDes = findViewById(R.id.txt_des);
        mViewLine = findViewById(R.id.view_line);
        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        goodsListBeans = new ArrayList<>();
        brandGoodsAdapter = new BrandGoodsAdapter(goodsListBeans, this);
        mRecyclerView.setAdapter(brandGoodsAdapter);

    }

    @Override
    protected void initData() {
        brandld = getIntent().getIntExtra("brandld", 0);
        persenter.getBrandInfo(String.valueOf(brandld));
        persenter.getBrandGoods(String.valueOf(brandld),1,1000);
    }

    @Override
    protected BrandConstract.Persenter createPersenter() {
        return new BrandPersenter();
    }

    @Override
    public void getBrandInfoReturn(BrandBean result) {
        Glide.with(this).load(result.getData().getBrand().getNew_pic_url()).into(mImgBg);
        mTxtName.setText(result.getData().getBrand().getName());
        mTxtDes.setText(result.getData().getBrand().getSimple_desc());
    }

    @Override
    public void getBrandGoodsReturn(BrandGoodsBean result) {
            brandGoodsAdapter.updata(result.getData().getGoodsList());
    }
}
