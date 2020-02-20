package com.example.mykuangjia.ui.classification.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.classification.CategoryConstract;
import com.example.mykuangjia.models.bean.CategoryListBean;
import com.example.mykuangjia.models.bean.CategoryTabBean;
import com.example.mykuangjia.persenter.classification.CategoryPersenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryActivity extends BaseActivity<CategoryConstract.View, CategoryConstract.Persenter>
        implements CategoryConstract.View, TabLayout.BaseOnTabSelectedListener {
    private ImageView mImgBack;
    private TabLayout mTabLayout;
    private TextView mTxtTitle;
    private TextView mTxtDesc;
    private LinearLayout mTxtLayout;
    private RecyclerView mRecyclerview;
    private ArrayList<CategoryListBean.DataBeanX.GoodsListBean> list;
    private CategoryAdapter categoryAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_category;

    }

    @Override
    protected void initView() {
        mImgBack = findViewById(R.id.img_back);
        mTabLayout = findViewById(R.id.tabLayout);
        mTxtTitle = findViewById(R.id.txt_title);
        mTxtDesc = findViewById(R.id.txt_desc);
        mTxtLayout = findViewById(R.id.txtLayout);
        mRecyclerview = findViewById(R.id.recyclerview);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        list = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(list, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerview.setLayoutManager(layoutManager);
        mRecyclerview.setAdapter(categoryAdapter);
        mTabLayout.addOnTabSelectedListener(this);


    }

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra("id",0);
        //获取tab相关的数据
        persenter.getCategoryTab(id);
    }

    @Override
    protected CategoryConstract.Persenter createPersenter() {
        return new CategoryPersenter();
    }




    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int id = (int) tab.getTag();
        persenter.getGoodsList(id,1,1000);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void getCategoryTabReturn(CategoryTabBean result) {
        int postion = -1;
        for(int i=0; i<result.getData().getBrotherCategory().size(); i++){
            CategoryTabBean.DataBean.BrotherCategoryBean item = result.getData().getBrotherCategory().get(i);
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(item.getName());
            tab.setTag(item.getId());
            mTabLayout.addTab(tab);
            if(result.getData().getCurrentCategory().getId() == item.getId()){
                postion = i;
            }
        }
        mTxtTitle.setText(result.getData().getCurrentCategory().getName());
        mTxtDesc.setText(result.getData().getCurrentCategory().getFront_desc());
        //设置选中的tab
        if(postion >= 0){
            mTabLayout.getTabAt(postion).select();
            //获取tab对应的列表数据
            persenter.getGoodsList(result.getData().getCurrentCategory().getId(),1,1000);
        }

    }

    @Override
    public void getGoodsListReturn(CategoryListBean result) {
        list.clear();
        list.addAll(result.getData().getGoodsList());
        categoryAdapter.notifyDataSetChanged();
    }
}
