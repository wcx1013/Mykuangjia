package com.example.mykuangjia.ui.special;

import android.view.View;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseFragment;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.special.SpecialConstract;
import com.example.mykuangjia.models.bean.TopicListBean;
import com.example.mykuangjia.persenter.special.SpecialPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SpecialFragment extends BaseFragment<SpecialConstract.View, SpecialConstract.Persenter>
        implements SpecialConstract.View, BaseAdapter.OnItemClickListener {
    private TextView mTextView;
    private RecyclerView mRecyc;
    private ArrayList<TopicListBean> topicListBeans;
    private SpecialAdapter specialAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_zhuanti;

    }

    @Override
    protected void initView() {
        mTextView = getView().findViewById(R.id.textView);
        mRecyc = getView().findViewById(R.id.recyc);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyc.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        mRecyc.setLayoutManager(manager);
        topicListBeans = new ArrayList<>();
        specialAdapter = new SpecialAdapter(topicListBeans, getContext());
        mRecyc.setAdapter(specialAdapter);
    }

    @Override
    protected void initData() {
        persenter.getTopic();
    }

    @Override
    protected SpecialConstract.Persenter createPersenter() {
        return new SpecialPresenter();
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {

    }

    @Override
    public void onItemClick(View v, int position) {

    }


    @Override
    public void getSpecial(TopicListBean result) {
            specialAdapter.updata((List) result);
    }
}
