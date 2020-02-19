package com.example.mykuangjia.ui.classification;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseFragment;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.classification.CatalogContract;
import com.example.mykuangjia.models.bean.CatalogItem;
import com.example.mykuangjia.models.bean.CatalogListBean;
import com.example.mykuangjia.models.bean.CatalogTabBean;
import com.example.mykuangjia.persenter.classification.CatalogPersenter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class ClassificationFragment extends BaseFragment<CatalogContract.View,CatalogContract.Persenter>
        implements CatalogContract.View,
        VerticalTabLayout.OnTabSelectedListener, BaseAdapter.OnItemClickListener{

    VerticalTabLayout verticalTabLayout;
    ImageView img;
    TextView txtDesc;
    TextView txtTitle;
    RecyclerView recyclerView;
    private ArrayList<String> titles;
    private ArrayList<CatalogTabBean.DataBean.CategoryListBean> categoryListBeans;
    private ArrayList<CatalogItem> list;
    private ClassificationAdapter classificationAdapter;
    private List<CatalogTabBean.DataBean.CategoryListBean> categoryList;

    @Override
    protected int getLayout() {
        return R.layout.fragment_fenlei;
    }

    @Override
    protected void initView() {
         verticalTabLayout = getView().findViewById(R.id.verticalTab);
        img = getView().findViewById(R.id.img);
        txtTitle = getView().findViewById(R.id.txt_title);
        txtDesc = getView().findViewById(R.id.txt_desc);
        recyclerView = getView().findViewById(R.id.recyclerview);

        titles = new ArrayList<>();
       // GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
        list = new ArrayList<>();
        classificationAdapter = new ClassificationAdapter(list, getContext());
        //禁止recyclerview垂直滚动
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        //   categoryListBeans = new ArrayList<>();
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(classificationAdapter);
            classificationAdapter.setOnItemClickListener(this);
            verticalTabLayout.addOnTabSelectedListener(this);

    }

    //创建竖导航的tabadapter
    TabAdapter tabAdapter=new TabAdapter() {
        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public ITabView.TabBadge getBadge(int position) {
            return null;
        }

        @Override
        public ITabView.TabIcon getIcon(int position) {
            return null;
        }

        @Override
        public ITabView.TabTitle getTitle(int position) {
            ITabView.TabTitle title = new QTabView.TabTitle.Builder()
                    .setContent(titles.get(position))
                    .build();

            return title;
        }

        @Override
        public int getBackground(int position) {
            return Color.parseColor("#D81B60");
        }
    };

    @Override
    protected void initData() {
        persenter.getCatalogTabData();
        //加载分类的tab数据
    }

    @Override
    protected CatalogContract.Persenter createPersenter() {
        return new CatalogPersenter();
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {

    }

    @Override
    public void onItemClick(View v, int position) {

    }



    @Override
    public void onTabSelected(TabView tab, int position) {

    }

    @Override
    public void onTabReselected(TabView tab, int position) {

    }

    //加载分类数据的导航返回
    @Override
    public void getCatalogTabDataReturn(CatalogTabBean result) {
        categoryList = result.getData().getCategoryList();
        titles.clear();
        //筛选竖导航的标题数据
        for(CatalogTabBean.DataBean.CategoryListBean item : result.getData().getCategoryList()) {
            titles.add(item.getName());
        }
        verticalTabLayout.setTabAdapter(tabAdapter);
        updateInfo(result.getData().getCurrentCategory().getBanner_url(),result.getData().getCurrentCategory().getFront_desc(),
                result.getData().getCurrentCategory().getName()+"分类");
        //刷新列表
        list.clear();
        for(CatalogTabBean.DataBean.CurrentCategoryBean.SubCategoryListBean item:result.getData().getCurrentCategory().getSubCategoryList()){
            CatalogItem catalogItem = new CatalogItem();
            catalogItem.id = item.getId();
            catalogItem.img= item.getWap_banner_url();
            catalogItem.name = item.getName();
            list.add(catalogItem);
        }
        classificationAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCatalogListReturn(CatalogListBean result) {
        updateInfo(result.getData().getCurrentCategory().getBanner_url(),result.getData().getCurrentCategory().getFront_desc(),
                result.getData().getCurrentCategory().getName()+"分类");

        list.clear();
        for(CatalogListBean.DataBean.CurrentCategoryBean.SubCategoryListBean item:result.getData().getCurrentCategory().getSubCategoryList()){
            CatalogItem catalogItem = new CatalogItem();
            catalogItem.id = item.getId();
            catalogItem.img= item.getWap_banner_url();
            catalogItem.name = item.getName();
            list.add(catalogItem);
        }
        classificationAdapter.notifyDataSetChanged();

    }
    //刷新右边的界面
    private void updateInfo(String imgUrl,String des,String title){
        if(!TextUtils.isEmpty(imgUrl)){
            Glide.with(context).load(imgUrl).into(img);
        }
        txtDesc.setText(des);
        txtTitle.setText(title);
    }
}
