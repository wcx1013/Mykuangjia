package com.example.mykuangjia.ui.home.activity;


import android.content.Context;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BrandDetailAdapter extends BaseAdapter {

    public BrandDetailAdapter(List mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.brand_detail_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
