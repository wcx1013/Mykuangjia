package com.example.mykuangjia.ui.shoppingcart.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.models.bean.AddressBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdressAdapter extends BaseAdapter {

    private ImageView imgEditor;

    public AdressAdapter(List mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_adresslist_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        AddressBean.DataBean bean = (AddressBean.DataBean) o;
        TextView txtName = (TextView) holder.getView(R.id.txt_name);
        TextView txtDefault = (TextView) holder.getView(R.id.txt_default);
        TextView txtPhone = (TextView) holder.getView(R.id.txt_phone);
        TextView txtAdress = (TextView) holder.getView(R.id.txt_adress);
        imgEditor = (ImageView) holder.getView(R.id.img_editor);
        txtName.setText(bean.getName());
        txtDefault.setVisibility(bean.getIs_default() == 1 ? View.VISIBLE : View.GONE);
        txtPhone.setText(bean.getMobile());
        txtAdress.setText(bean.getCity_name()+bean.getDistrict_name()+bean.getFull_region());

        imgEditor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(onItemClickListener != null){
//                    onItemClickListener.itemClick(holder.getLayoutPosition(),holder);
//                }
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
