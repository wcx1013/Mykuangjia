package com.example.mykuangjia.ui.shoppingcart.adapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.models.bean.RegionBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdressSelectAdapter extends BaseAdapter {

    public int curSelectId;

    public AdressSelectAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_adress_select_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        RegionBean.DataBean data = (RegionBean.DataBean) o;
        TextView txtName = (TextView) holder.getView(R.id.txt_name);
        if(curSelectId == data.getId()){
            txtName.setTextColor(Color.parseColor("#ffff00"));
        }else{
            txtName.setTextColor(Color.parseColor("#000000"));
        }
        txtName.setText(data.getName());
    }




    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
