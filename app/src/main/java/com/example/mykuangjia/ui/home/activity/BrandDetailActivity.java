package com.example.mykuangjia.ui.home.activity;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.interfaces.home.BrandDetailConstract;
import com.example.mykuangjia.models.bean.BrandDetialBean;
import com.example.mykuangjia.persenter.home.BrandDetailPersenter;

import java.util.ArrayList;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BrandDetailActivity extends BaseActivity<IBaseView, BrandDetailConstract.Persenter> implements BrandDetailConstract.View {
    private RecyclerView mBrandDetailRecy;
    private ArrayList<BrandDetialBean.DataBeanX.DataBean> brandDetailList;
    private BrandDetailAdapter brandDetailAdapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_branddetail;

    }

    @Override
    protected void initView() {
        mBrandDetailRecy = findViewById(R.id.brand_detail_recy);
        brandDetailList = new ArrayList<>();
        brandDetailAdapter = new BrandDetailAdapter(brandDetailList, this);
        mBrandDetailRecy.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mBrandDetailRecy.setLayoutManager(new LinearLayoutManager(this));
        mBrandDetailRecy.setAdapter(brandDetailAdapter);
    }

    @Override
    protected void initData() {
        persenter.getBrandDetail(1,1000);
    }

    @Override
    protected BrandDetailConstract.Persenter createPersenter() {
        return new BrandDetailPersenter();
    }

    @Override
    public void getBrandDetailReturn(BrandDetialBean result) {
        brandDetailAdapter.updata(result.getData().getData());
    }
}
