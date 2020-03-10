package com.example.mykuangjia.ui.shoppingcart.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.base.adapter.BaseAdapter;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.interfaces.shoppingcart.ShoppingConstact;
import com.example.mykuangjia.models.bean.AddressBean;
import com.example.mykuangjia.models.bean.AdressSaveBean;
import com.example.mykuangjia.models.bean.RegionBean;
import com.example.mykuangjia.persenter.cart.AdressNewPresenter;
import com.example.mykuangjia.ui.shoppingcart.adapter.AdressSelectAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;

public class AdressEditorActivity extends BaseActivity<IBaseView, ShoppingConstact.AdressNewPresenter> implements ShoppingConstact.AdressNewView {
    private TextView mTxtName;
    private TextView mTxtPhone;
    private TextView mTxtAdress;
    private TextView mTxtAdressInfo;
    private CheckBox mCheckboxDefault;
    private TextView mTxtCancel;
    private TextView mTxtSave;
    PopupWindow popupWindow;//
    AddressBean.DataBean addressBean;

    TextView txtProvince,txtCity,txtArea,txtOk;
    RecyclerView recyAdress;
    AdressSelectAdapter adressSelectAdapter;
    List<RegionBean.DataBean> adressList;
    int pid,cid,aid; //当前选着省份，城市，区县id

    @Override
    protected int getLayout() {
        return R.layout.activity_adress_editor;

    }

    @Override
    protected void initView() {
        mTxtName = findViewById(R.id.txt_name);
        mTxtPhone = findViewById(R.id.txt_phone);
        mTxtAdress = findViewById(R.id.txt_adress);
        mTxtAdressInfo = findViewById(R.id.txt_adress_info);
        mCheckboxDefault = findViewById(R.id.checkbox_default);
        mTxtCancel = findViewById(R.id.txt_cancel);
        mTxtSave = findViewById(R.id.txt_save);
    }

    @Override
    protected void initData() {
        if (getIntent().hasExtra("adress")) {
            addressBean = (AddressBean.DataBean) getIntent().getSerializableExtra("adress");
            pid = addressBean.getProvince_id();
            cid = addressBean.getCity_id();
            aid = addressBean.getDistrict_id();
            mTxtName.setText(addressBean.getName());
            mTxtPhone.setText(addressBean.getMobile());
            mTxtAdress.setText(addressBean.getProvince_name()+addressBean.getCity_name()+addressBean.getDistrict_name());
            mTxtAdressInfo.setText(addressBean.getAddress());
            mCheckboxDefault.setChecked(addressBean.getIs_default() == 1 ? true : false);
        }
    }

    @Override
    protected ShoppingConstact.AdressNewPresenter createPersenter() {
        return new AdressNewPresenter();
    }
    @OnClick({R.id.txt_cancel, R.id.txt_save,R.id.txt_adress})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_cancel:
                finish();
                break;
            case R.id.txt_save:
                saveAdress();
                break;
            case R.id.txt_adress:
                openAdressWindow();
                break;
        }
    }


    @Override
    public void saveAdressReturn(AdressSaveBean result) {
        finish();
    }

    @Override
    public void getRegionReturn(RegionBean result) {
        if(popupWindow.isShowing()){
            adressSelectAdapter.updata(result.getData());
        }
    }
    //打开popupwindow
    private void openAdressWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow_adress,null);
        popupWindow = new PopupWindow(view,200, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        //popupWindow.setAnimationStyle(R.style.MyPopuStyle);
       // popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        txtProvince = view.findViewById(R.id.txt_province);
        txtCity = view.findViewById(R.id.txt_city);
        txtArea = view.findViewById(R.id.txt_area);
        txtOk = view.findViewById(R.id.txt_ok);
        recyAdress = view.findViewById(R.id.recy_adress);
        txtProvince.setOnClickListener(clickListener);
        txtCity.setOnClickListener(clickListener);

        adressList = new ArrayList<>();
        adressSelectAdapter = new AdressSelectAdapter(adressList,this);
        recyAdress.setLayoutManager(new LinearLayoutManager(this));
        recyAdress.setAdapter(adressSelectAdapter);
        //设置条目点击的接口回调
        adressSelectAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                RegionBean.DataBean bean = adressList.get(position);
                int id = bean.getId();
                resetSelectTxtStyle();  //重置文本样式
                if(bean.getType() == 1){  //选中的省份
                    persenter.getRegion(id);
                    txtProvince.setText(bean.getName());
                    pid = id;
                    cid = 0;
                    aid = 0;
                    txtCity.setTextColor(Color.parseColor("#ff0000"));
                }else if(bean.getType() == 2){  //选中的是城市
                    persenter.getRegion(id);
                    txtArea.setTextColor(Color.parseColor("#ff0000"));
                    txtCity.setText(bean.getName());
                    cid = id;
                    aid = 0;
                }else{ //选中的是区县
                    txtArea.setText(bean.getName());
                    aid = id;
                    adressSelectAdapter.curSelectId = aid;
                    adressSelectAdapter.notifyDataSetChanged();
                }
            }
        });


        txtOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pid == 0 || cid == 0 || aid == 0){
                    showTips("请选择省份数据");
                    return;
                }
                mTxtAdress.setText(txtProvince.getText().toString()+txtCity.getText().toString()+txtArea.getText().toString());
                popupWindow.dismiss();
            }
        });


        //设置默认值
        if(addressBean != null){
            txtProvince.setText(addressBean.getProvince_name());
            txtCity.setText(addressBean.getCity_name());
            txtArea.setText(addressBean.getDistrict_name());
            txtArea.setTextColor(Color.parseColor("#ff0000"));
            persenter.getRegion(addressBean.getCity_id());
        }else{
            //默认设置省份的颜色
            txtProvince.setTextColor(Color.parseColor("#ff0000"));
            persenter.getRegion(1);
        }

    }
    //设置省份和城市的点击事件
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.txt_province:
                    adressSelectAdapter.curSelectId = pid;
                    persenter.getRegion(1);
                    break;
                case R.id.txt_city:
                    adressSelectAdapter.curSelectId = cid;
                    persenter.getRegion(pid);
                    break;
            }
        }
    };

    //重置文本样式
    private void resetSelectTxtStyle(){
        txtProvince.setTextColor(Color.parseColor("#000000"));
        txtCity.setTextColor(Color.parseColor("#000000"));
        txtArea.setTextColor(Color.parseColor("#000000"));
    }


    //执行保存地址操作
    private void saveAdress(){
        Map<String,String> map = new HashMap<>();
        if(addressBean == null){
            map.put("id","0");
        }else{
            map.put("id",String.valueOf(addressBean.getId()));
        }
        map.put("name",mTxtName.getText().toString());
        map.put("mobile",mTxtPhone.getText().toString());
        map.put("province_id",String.valueOf(pid));
        map.put("city_id",String.valueOf(cid));
        map.put("district_id",String.valueOf(aid));
        map.put("address",mTxtAdressInfo.getText().toString());
        String defalt = mCheckboxDefault.isChecked() ? "1" : "0";
        map.put("is_default",defalt);
        persenter.saveAdress(map);
    }
}
