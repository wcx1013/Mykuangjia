package com.example.mykuangjia.ui.classification;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.models.bean.CatalogItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClassificationAdapter extends BaseAdapter {
    public ClassificationAdapter(List mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.catalog_list_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        CatalogItem bean = (CatalogItem) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.img_icon);
        Glide.with(mContext).load(bean.img).into(img);
        TextView txtName = (TextView) holder.getView(R.id.txt_name);
        txtName.setText(bean.name);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
