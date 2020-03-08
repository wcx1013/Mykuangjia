package com.example.mykuangjia.ui.own;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseFragment;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.IBasePersenter;
import com.example.mykuangjia.models.bean.MyHomeItemBean;

import java.util.ArrayList;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OwnFragment extends BaseFragment {
    private ImageView mMyIv;
    private TextView mMyTv;
    private RecyclerView mRecyclerview;
    private ArrayList<MyHomeItemBean> al;
    private OwnAdapter ownAdapter;
    @Override
    protected int getLayout() {
        return R.layout.fragment_me;

    }

    @Override
    protected void initView() {
        mMyIv = getView().findViewById(R.id.my_iv);
        mMyTv = getView().findViewById(R.id.my_tv);
        mRecyclerview = getView().findViewById(R.id.recyclerview);

        RequestOptions requestOptions = new RequestOptions();
        Glide.with(getContext()).load(R.mipmap.zw).apply(requestOptions.circleCrop()).into(mMyIv);
        al = new ArrayList<>();
        initList();
        ownAdapter = new OwnAdapter(al,context);
        mRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        mRecyclerview.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecyclerview.setAdapter(ownAdapter);
        ownAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {

    }
    private void initList() {
        al.add(new MyHomeItemBean(R.mipmap.home,"我的订单"));
        al.add(new MyHomeItemBean(R.mipmap.home,"优惠券"));
        al.add(new MyHomeItemBean(R.mipmap.home,"礼品卡"));
        al.add(new MyHomeItemBean(R.mipmap.home,"我的收藏"));
        al.add(new MyHomeItemBean(R.mipmap.home,"我的足迹"));
        al.add(new MyHomeItemBean(R.mipmap.home,"会员福利"));
        al.add(new MyHomeItemBean(R.mipmap.home,"地址管理"));
        al.add(new MyHomeItemBean(R.mipmap.home,"账号安全"));
        al.add(new MyHomeItemBean(R.mipmap.home,"联系客服"));
        al.add(new MyHomeItemBean(R.mipmap.home,"帮助中心"));
        al.add(new MyHomeItemBean(R.mipmap.home,"意见反馈"));
    }
    @Override
    protected IBasePersenter createPersenter() {
        return null;
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {

    }
}
