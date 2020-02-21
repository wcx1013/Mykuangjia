package com.example.mykuangjia.ui.special;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.common.Constant;
import com.example.mykuangjia.models.bean.TopicListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpecialAdapter extends BaseAdapter {
    public SpecialAdapter(List mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_topic;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
       // IndexBean.DataBean.BrandListBean data= (IndexBean.DataBean.BrandListBean) o;
        TopicListBean data= (TopicListBean) o;
        ImageView img_brand = (ImageView) holder.getView(R.id.img_brand);
        TextView txt_name = (TextView) holder.getView(R.id.txt_name);
        TextView txt_price = (TextView) holder.getView(R.id.txt_price);
        Glide.with(mContext).load(data.getItem_pic_url()).into(img_brand);
        txt_name.setText(data.getTitle());
        txt_price.setText(Constant.PRICE_MODEL.replace("$",data.getPrice_info()));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
