package com.example.mykuangjia.ui.shoppingcart;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseFragment;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.shoppingcart.ShoppingConstact;
import com.example.mykuangjia.models.bean.CartBean;
import com.example.mykuangjia.persenter.cart.ShoppingPresenter;
import com.example.mykuangjia.ui.login.LoginActivity;
import com.example.mykuangjia.ui.shoppingcart.adapter.ShoppingAdapter;
import com.example.mykuangjia.utils.SpUtils;

import java.util.ArrayList;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;

public class ShoppingcartFragment extends BaseFragment<ShoppingConstact.View, ShoppingConstact.Presenter>
        implements ShoppingConstact.View, BaseAdapter.OnItemClickListener {
    private RecyclerView mCartList;
    private RadioButton mRadioAll;
    private TextView mTxtTotalPrice;
    private TextView mTxtOrder;
    private TextView mTxtEdit;
    private ConstraintLayout mLayoutCommon;
    private ArrayList<CartBean.DataBean.CartListBean> list;
    RecyclerView cartList;
    ShoppingAdapter shoppingAdapter;
    @Override
    protected int getLayout() {
        return R.layout.fragment_shoping;

    }

    @Override
    protected void initView() {
        mCartList = getView().findViewById(R.id.cart_list);
        mRadioAll = getView().findViewById(R.id.radio_all);
        mTxtTotalPrice = getView().findViewById(R.id.txt_TotalPrice);
        mTxtOrder = getView().findViewById(R.id.txt_order);
        mTxtEdit = getView().findViewById(R.id.txt_edit);
        mLayoutCommon = getView().findViewById(R.id.layout_common);
        list = new ArrayList<>();
        cartList.setLayoutManager(new LinearLayoutManager(context));
        cartList.setAdapter(shoppingAdapter);
        mRadioAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setSelectAll();
                shoppingAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void initData() {
        //如果用户没有登录就要
        String token = SpUtils.getInstance().getString("token");
        if (TextUtils.isEmpty(token)) {
            Intent intent = new Intent(context, LoginActivity.class);
            startActivity(intent);
        } else {
            persenter.getCartIndex();
        }
    }

    @Override
    protected ShoppingConstact.Presenter createPersenter() {
        return new ShoppingPresenter();
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        updateSelectAll();
    }

    @Override
    public void onItemClick(View v, int position) {

    }

    @Override
    public void getCartIndexReturn(CartBean result) {
        shoppingAdapter.updata(result.getData().getCartList());
    }

    //mTxtEdit
    @OnClick({R.id.txt_order,R.id.txt_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_order:

                break;
            case R.id.txt_edit:
                String str = mTxtEdit.getText().toString();
                if(str.equals("编辑")){
                    mTxtEdit.setText("完成");
                    shoppingAdapter.isEdit = true;
                    shoppingAdapter.notifyDataSetChanged();
                }else{
                    mTxtEdit.setText("编辑");
                    shoppingAdapter.isEdit = false;
                    //提交编辑页面的数据
                }
                break;
        }
    }


    /**
     * 设置全部选中
     */
    private void setSelectAll(){
        for(CartBean.DataBean.CartListBean item:list){
            item.isSelect = true;
        }
    }

    /**
     * 检查是否全部选择
     * @return
     */
    private void updateSelectAll(){
        //int[] arr = new int[3]; //用一个数组来记录当前是否全选，选中的商品数量，总的价格
        int totalPrice = 0;
        int nums = 0;
        boolean isAll = true; //是否全选
        for(int i=0; i<list.size(); i++){
            if(!shoppingAdapter.isEdit){
                boolean isSelect = list.get(i).isSelect;
                //记录判断是否全选
                if(isAll){
                    isAll = isSelect;
                }
                //计算选中的商品数量和价格
                if(isSelect){
                    nums += list.get(i).getNumber();
                    totalPrice += list.get(i).getNumber()*list.get(i).getRetail_price();
                }
            }else{
                boolean isDelSelect = list.get(i).isDelSelect;
                if(isAll){
                    isAll = isDelSelect;
                }
                if(isDelSelect){
                    nums += list.get(i).getNumber();
                }
            }
        }

        mRadioAll.setChecked(isAll);
        mRadioAll.setText("全选("+nums+")");
        if(!shoppingAdapter.isEdit){
            String price = context.getResources().getString(R.string.price_news_model);
            price = price.replace("$",String.valueOf(totalPrice));
            mTxtTotalPrice.setText(price);
        }else{
            mTxtTotalPrice.setText("");
        }
    }
}
