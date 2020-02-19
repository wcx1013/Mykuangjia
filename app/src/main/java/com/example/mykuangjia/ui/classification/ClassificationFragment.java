package com.example.mykuangjia.ui.classification;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseFragment;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.home.HomeConstract;
import com.example.mykuangjia.models.bean.IndexBean;

import androidx.recyclerview.widget.RecyclerView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.TabView;

public class ClassificationFragment extends BaseFragment<HomeConstract.View,HomeConstract.Persenter> implements HomeConstract.View,
        VerticalTabLayout.OnTabSelectedListener, BaseAdapter.OnItemClickListener{

    VerticalTabLayout verticalTabLayout;
    ImageView img;
    TextView txtDesc;
    TextView txtTitle;
    RecyclerView recyclerView;
    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initView() {
         verticalTabLayout = getView().findViewById(R.id.verticalTab);
        img = getView().findViewById(R.id.img);
        txtTitle = getView().findViewById(R.id.txt_title);
        txtDesc = getView().findViewById(R.id.txt_desc);
        recyclerView = getView().findViewById(R.id.recyclerview);




    }

    @Override
    protected void initData() {

    }

    @Override
    protected IBasePersenter createPersenter() {
        return null;
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {

    }

    @Override
    public void onItemClick(View v, int position) {

    }

    @Override
    public void getHomeDataReturn(IndexBean result) {

    }

    @Override
    public void onTabSelected(TabView tab, int position) {

    }

    @Override
    public void onTabReselected(TabView tab, int position) {

    }
}
