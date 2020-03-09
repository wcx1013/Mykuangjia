package com.example.mykuangjia.ui.shoppingcart.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.interfaces.shoppingcart.ShoppingConstact;
import com.example.mykuangjia.models.bean.AddressBean;
import com.example.mykuangjia.models.bean.AdressSaveBean;
import com.example.mykuangjia.models.bean.RegionBean;
import com.example.mykuangjia.persenter.cart.AdressNewPresenter;

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

    }

    @Override
    public void getRegionReturn(RegionBean result) {

    }
    //打开popupwindow
    private void openAdressWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow_adress,null);
        popupWindow = new PopupWindow(view,200, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setTouchable(true);
        popupWindow.setAnimationStyle(R.style.MyPopuStyle);
        popupWindow.setOutsideTouchable(true);
       // popupWindow.showAtLocation(mLl, Gravity.CENTER, 0, 0);
    }


    //执行保存地址操作
    private void saveAdress(){
        if(addressBean == null){
            addressBean = new AddressBean.DataBean();
        }
        //persenter.saveAdress();
    }
}
