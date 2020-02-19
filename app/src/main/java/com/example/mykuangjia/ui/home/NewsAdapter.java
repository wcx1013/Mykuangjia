package com.example.mykuangjia.ui.home;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.models.bean.IndexBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends BaseAdapter {
    public NewsAdapter(List mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_news_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        IndexBean.DataBean.NewGoodsListBean bean= (IndexBean.DataBean.NewGoodsListBean) o;
        ImageView img_news = (ImageView) holder.getView(R.id.img_news);
        TextView txt_name = (TextView) holder.getView(R.id.txt_name);
        TextView txt_price = (TextView) holder.getView(R.id.txt_price);
        Glide.with(mContext).load(bean.getList_pic_url()).into(img_news);
        txt_name.setText(bean.getName());
        String price=mContext.getResources().getString(R.string.price_news_model);
        txt_price.setText(price.replace("$",bean.getRetail_price()));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
