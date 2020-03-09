package com.example.mykuangjia.ui.shoppingcart.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.interfaces.shoppingcart.ShoppingConstact;
import com.example.mykuangjia.models.bean.AddressBean;
import com.example.mykuangjia.persenter.cart.AdressPresenter;
import com.example.mykuangjia.ui.shoppingcart.adapter.AdressAdapter;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;

public class AdressListActivity extends BaseActivity<IBaseView, ShoppingConstact.AdressPresenter>
        implements ShoppingConstact.AdressView, BaseAdapter.OnItemClickListener {
    private RecyclerView mRecyAdressList;
    private TextView mTxtNew;
    private ArrayList<AddressBean.DataBean> list;
    AdressAdapter adressAdapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_adress_list;

    }

    @Override
    protected void initView() {
        mRecyAdressList = findViewById(R.id.recy_adress_list);
        mTxtNew = findViewById(R.id.txt_new);
        list = new ArrayList<>();
        adressAdapter = new AdressAdapter(list,this);
        mRecyAdressList.setLayoutManager(new LinearLayoutManager(this));
        mRecyAdressList.setAdapter(adressAdapter);

    }

    @Override
    protected void initData() {
        persenter.getAdressList();
    }

    @Override
    protected ShoppingConstact.AdressPresenter createPersenter() {
        return new AdressPresenter();
    }
    //调整新建地址页面
    @OnClick(R.id.txt_new)
    public void onViewClicked() {
        Intent intent = new Intent(this,AdressEditorActivity.class);
        startActivity(intent);
    }



    @Override
    public void getAdressListReturn(AddressBean result) {
        adressAdapter.updata(result.getData());
    }

    @Override
    public void onItemClick(View v, int position) {
        AddressBean.DataBean item = list.get(position);
        //进入地址编辑的页面
        Intent intent = new Intent(this,AdressEditorActivity.class);
        intent.putExtra("adress",item);
        startActivity(intent);
    }
}
