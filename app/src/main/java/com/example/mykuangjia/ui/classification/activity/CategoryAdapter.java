package com.example.mykuangjia.ui.classification.activity;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.models.bean.CategoryListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter extends BaseAdapter {
    public CategoryAdapter(List mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_goodlist_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        CategoryListBean.DataBeanX.GoodsListBean bean = (CategoryListBean.DataBeanX.GoodsListBean) mDatas.get(positon);
        ImageView img = (ImageView)holder.getView(R.id.img_icon);
        Glide.with(mContext).load(bean.getList_pic_url()).into(img);
        TextView txtName = (TextView)holder.getView(R.id.txt_name);
        txtName.setText(bean.getName());
        TextView txtPrice = (TextView)holder.getView(R.id.txt_price);
        txtPrice.setText(bean.getRetail_price()+"元起");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
