package com.example.mykuangjia.ui.own;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.models.bean.MyHomeItemBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OwnAdapter extends BaseAdapter {
    public OwnAdapter(List mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.me_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        MyHomeItemBean homeItemBean= (MyHomeItemBean) o;
        ImageView me_iv = (ImageView) holder.getView(R.id.me_recy_iv);
        TextView me_tv = (TextView) holder.getView(R.id.me_recy_tv);
        me_iv.setImageResource(homeItemBean.getImage());
        me_tv.setText(homeItemBean.getTitle());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
