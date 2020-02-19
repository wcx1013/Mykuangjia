package com.example.mykuangjia.ui.home;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseFragment;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.interfaces.home.HomeConstract;
import com.example.mykuangjia.models.bean.IndexBean;
import com.example.mykuangjia.persenter.home.HomePersenter;
import com.example.mykuangjia.ui.home.activity.BrandActivity;

import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends BaseFragment<HomeConstract.View,HomeConstract.Persenter>
        implements HomeConstract.View, BaseAdapter.OnItemClickListener {


    private RecyclerView recyclerView;
    private RecyclerView recyclerViewNews;
    private ArrayList<IndexBean.DataBean.BrandListBean> list;
    private BrandAdapter brandAdapter;
    private ArrayList<IndexBean.DataBean.NewGoodsListBean> newList;
    private NewsAdapter newsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        recyclerView = getView().findViewById(R.id.recyclerView);
        recyclerViewNews = getView().findViewById(R.id.recyclerView_News);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        list = new ArrayList<>();
        brandAdapter = new BrandAdapter(list, context);
        recyclerView.setAdapter(brandAdapter);
        brandAdapter.setOnItemClickListener(this);


       recyclerViewNews.setLayoutManager(new GridLayoutManager(context,2));
       newList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newList, context);
       recyclerViewNews.setAdapter(newsAdapter);

        newsAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.i("newsItemClick",String.valueOf(position));
            }
        });


    }

    @Override
    protected void initData() {
        persenter.getHomeData();
    }

    @Override
    protected IBasePersenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        IndexBean.DataBean.BrandListBean bean = list.get(position);
        ((TextView)holder.getView(R.id.txt_name)).setText(bean.getName()+"新的名字");

        //跳到详情界面
        Intent intent = new Intent(getContext(), BrandActivity.class);
        intent.putExtra("brandid",bean.getId());
        startActivity(intent);

    }

    @Override
    public void getHomeDataReturn(IndexBean result) {
        brandAdapter.updata(result.getData().getBrandList());
        newsAdapter.updata(result.getData().getNewGoodsList());

    }

    @Override
    public void onItemClick(View v, int position) {

    }
}
