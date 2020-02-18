package com.example.mykuangjia.ui.fragment1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.home.BrandConstract;
import com.example.mykuangjia.models.bean.BrandBean;
import com.example.mykuangjia.models.bean.BrandGoodsBean;
import com.example.mykuangjia.persenter.home.BrandPersenter;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class BrandActivity extends BaseActivity<BrandConstract.Persenter> implements BrandConstract.View {

    int brandId;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.img_bg)
    ImageView imgBg;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.layout_infos)
    ConstraintLayout layoutInfos;
    @BindView(R.id.txt_des)
    TextView txtDes;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;


    BrandGoodsAdapter brandGoodsAdapter;
    List<BrandGoodsBean.DataBeanX.GoodsListBean> goodsList;

    @Override
    protected int getLayout() {
        return R.layout.activity_brand;
    }

    @Override
    protected void initView() {
        goodsList = new ArrayList<>();
        brandGoodsAdapter = new BrandGoodsAdapter(goodsList,this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(brandGoodsAdapter);
    }

    @Override
    protected void initData() {
        brandId = getIntent().getIntExtra("brandId", 0);
        persenter.getBrandInfo(String.valueOf(brandId));
        persenter.getBrandGoods(String.valueOf(brandId), 1, 1000);
    }

    @Override
    protected BrandConstract.Persenter createPersenter() {
        return new BrandPersenter();
    }

    @Override
    public void getBrandInfoReturn(BrandBean result) {
        Glide.with(this).load(result.getData().getBrand().getNew_pic_url()).into(imgBg);
        txtName.setText(result.getData().getBrand().getName());
        txtDes.setText(result.getData().getBrand().getSimple_desc());
    }

    @Override
    public void getBrandGoodsReturn(BrandGoodsBean result) {
        brandGoodsAdapter.updata(result.getData().getGoodsList());
    }
}
