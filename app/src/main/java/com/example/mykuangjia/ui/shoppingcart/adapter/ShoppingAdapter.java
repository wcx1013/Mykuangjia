package com.example.mykuangjia.ui.shoppingcart.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.models.bean.CartBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingAdapter extends BaseAdapter {
    public boolean isEdit; //是否是编辑状态
    public ShoppingAdapter(List mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_shopping_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        ConstraintLayout layout_default = (ConstraintLayout) holder.getView(R.id.layout_default);
        ConstraintLayout layout_edit = (ConstraintLayout) holder.getView(R.id.layout_edit);
        layout_default.setVisibility(isEdit ? View.GONE : View.VISIBLE);
        layout_edit.setVisibility(isEdit ? View.VISIBLE : View.GONE);

        CartBean.DataBean.CartListBean listBean = (CartBean.DataBean.CartListBean) o;
        RadioButton radio_select = (RadioButton) holder.getView(R.id.radio_select);
        ImageView img_item = (ImageView) holder.getView(R.id.img_item);

        radio_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isEdit){
                    listBean.isSelect = isChecked;
                }else{
                    listBean.isDelSelect = isChecked;
                }
               // if(itemClickHandler != null){
                //    itemClickHandler.(holder.getLayoutPosition(),holder);
               // }
            }
        });

        //默认布局
        TextView txt_name = (TextView) holder.getView(R.id.txt_name);
        TextView txt_price = (TextView) holder.getView(R.id.txt_price);
        TextView txt_nums = (TextView) holder.getView(R.id.txt_nums);
        //编辑布局
        TextView txt_edit_price = (TextView) holder.getView(R.id.txt_edit_price);
        TextView txt_subtract = (TextView) holder.getView(R.id.txt_subtract);
        TextView txt_add = (TextView) holder.getView(R.id.txt_add);
        TextView txt_edit_nums = (TextView) holder.getView(R.id.txt_edit_nums);

        Glide.with(mContext).load(listBean.getList_pic_url()).into(img_item);

        if(!isEdit){
            radio_select.setChecked(listBean.isSelect);
            txt_name.setText(listBean.getGoods_name());
            String price = mContext.getResources().getString(R.string.price_news_model);
            price = price.replace("$",String.valueOf(listBean.getRetail_price()));
            txt_price.setText(price);
            txt_nums.setText(String.valueOf(listBean.getNumber()));
        }else{
            String price = mContext.getResources().getString(R.string.price_news_model);
            price = price.replace("$",String.valueOf(listBean.getRetail_price()));
            txt_edit_price.setText(price);
            txt_edit_nums.setText(String.valueOf(listBean.getNumber()));
            txt_subtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listBean.getNumber() == 1) return;
                    listBean.setNumber(listBean.getNumber()-1);
                    txt_edit_nums.setText(String.valueOf(listBean.getNumber()));
                }
            });
            txt_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listBean.setNumber(listBean.getNumber()+1);
                    txt_edit_nums.setText(String.valueOf(listBean.getNumber()));
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}
