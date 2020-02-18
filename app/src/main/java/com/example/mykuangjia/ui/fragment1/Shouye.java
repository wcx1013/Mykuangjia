package com.example.mykuangjia.ui.fragment1;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseFragment;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.home.HomeConstract;
import com.example.mykuangjia.models.bean.IndexBean;
import com.example.mykuangjia.persenter.home.HomePersenter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class Shouye extends BaseFragment<HomeConstract.Persenter>
        implements HomeConstract.View, BaseAdapter.OnItemClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerView_News)
    RecyclerView recyclerViewNews;

    BrandAdapter brandAdapter;
    List<IndexBean.DataBean.BrandListBean> list;

    NewsAdapter newsAdapter;
    List<IndexBean.DataBean.NewGoodsListBean> newsList;


    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        brandAdapter = new BrandAdapter(list,context);
        recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        recyclerView.setAdapter(brandAdapter);
        brandAdapter.setOnItemClickListener((BaseAdapter.OnItemClickListener) this);

        //初始化新品列表
        newsList = new ArrayList<>();
        newsAdapter = new NewsAdapter(newsList,context);
        recyclerViewNews.setLayoutManager(new GridLayoutManager(context,2));
        recyclerViewNews.setAdapter(newsAdapter);
        //避免当前类中多个列表的点击接口回调的冲突，建议使用匿名的类实例
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
    protected HomeConstract.Persenter createPersenter() {
        return new HomePersenter();
    }



    @Override
    public void getHomeDataReturn(IndexBean result) {
        //刷新Brand列表数据
        brandAdapter.updata(result.getData().getBrandList());
        //刷新新品发布列表数据
        newsAdapter.updata(result.getData().getNewGoodsList());
    }

    @Override
    public void onItemClick(View v, int position) {

    }

    /**
     * 接口回调的方法
     * @param position
     * @param
     */

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        IndexBean.DataBean.BrandListBean bean = list.get(position);
        ((TextView)holder.getView(R.id.txt_name)).setText(bean.getName()+"新的名字");
        Log.i("brand-click",String.valueOf(position));
        //跳转到brand详情页
        Intent intent = new Intent(getContext(), BrandActivity.class);
        intent.putExtra("brandId",bean.getId());
        startActivity(intent);
    }


}
