package com.example.mykuangjia.ui.cart;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.cart.CartConstart;
import com.example.mykuangjia.models.bean.RelatedBean;
import com.example.mykuangjia.persenter.cart.CartPersenter;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class GoodInfoActivity extends BaseActivity<CartConstart.View, CartConstart.Persenter> implements CartConstart.View {
    private TextView mTxtTitle;
    private TextView mTxtDes;
    private TextView mTxtPrice;
    private TextView mTxtNums;
    private ConstraintLayout mLayoutNums;
    private TextView mTxtParam;
    private TextView mTxtMetarial;
    private ConstraintLayout mLayoutMetarial;
    private TextView mTxtSize;
    private ConstraintLayout mLayoutSize;
    private TextView mTxtColor;
    private ConstraintLayout mLayoutColor;
    private TextView mTxtNorm;
    private ConstraintLayout mLayoutNorm;
    private TextView mTxtPlace;
    private WebView mMyWebView;
    private ConstraintLayout mTxtQuestion;
    private RecyclerView mRecyclerView;
    private TextView mTxtCollect;
    private TextView mTxtCart;
    private TextView mTxtBuy;
    private TextView mTxtAddCart;

    @Override
    protected int getLayout() {
        return R.layout.activity_goodinfo;

    }

    @Override
    protected void initView() {
        mTxtTitle = findViewById(R.id.txt_title);
        mTxtDes = findViewById(R.id.txt_des);
        mTxtPrice = findViewById(R.id.txt_price);
        mTxtNums = findViewById(R.id.txt_nums);
        mLayoutNums = findViewById(R.id.layout_nums);
        mTxtParam = findViewById(R.id.txt_param);
        mTxtMetarial = findViewById(R.id.txt_metarial);
        mLayoutMetarial = findViewById(R.id.layout_metarial);
        mTxtSize = findViewById(R.id.txt_size);
        mLayoutSize = findViewById(R.id.layout_size);
        mTxtColor = findViewById(R.id.txt_color);
        mLayoutColor = findViewById(R.id.layout_color);
        mTxtNorm = findViewById(R.id.txt_norm);
        mLayoutNorm = findViewById(R.id.layout_norm);
        mTxtPlace = findViewById(R.id.txt_place);
        mMyWebView = findViewById(R.id.myWebView);
        mTxtQuestion = findViewById(R.id.txt_question);
        mRecyclerView = findViewById(R.id.recyclerView);
        mTxtCollect = findViewById(R.id.txt_collect);
        mTxtCart = findViewById(R.id.txt_cart);
        mTxtBuy = findViewById(R.id.txt_buy);
        mTxtAddCart = findViewById(R.id.txt_addCart);

        WebSettings webSettings = mMyWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    protected void initData() {
        int relatedId = getIntent().getIntExtra("relatedId", 0);
        persenter.getRelatedData(relatedId);
    }

    @Override
    protected CartConstart.Persenter createPersenter() {
        return new CartPersenter();
    }

    @Override
    public void getRelatedDataReturn(RelatedBean result) {
        updateBanner(result.getData().getGallery());
        String replace = getResources().getString(R.string.price_news_model).replace("$", String.valueOf(result.getData().getInfo().getRetail_price()));
        updatePrice(result.getData().getInfo().getName(),result.getData().getInfo().getGoods_brief(),replace);
        updateWebView(result.getData().getInfo());

    }
    private void updateBanner(List<RelatedBean.DataBeanX.GalleryBean> list){
        //填充banner数据
    }
    //填充信息数据
    private void updatePrice(String name,String des,String price){
        mTxtTitle.setText(name);
        mTxtDes.setText(des);
        mTxtPrice.setText(price);
    }

    private void updateParam(){
        //填充规格数据
    }

    private void updateWebView(RelatedBean.DataBeanX.InfoBean infoBean){
        //商品介绍描述信息
        String css_str = getResources().getString(R.string.css_goods);
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head>");
        sb.append("<style>"+css_str+"</style></head><body>");
        sb.append(infoBean.getGoods_desc()+"</body></html>");
        mMyWebView.loadData(sb.toString(),"text/html","utf-8");
    }

    private void updateGoodList(){
        //商品列表
    }
}
