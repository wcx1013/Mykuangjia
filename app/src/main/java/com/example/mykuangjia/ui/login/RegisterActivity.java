package com.example.mykuangjia.ui.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.interfaces.login.RegisterConstract;
import com.example.mykuangjia.models.bean.VerifyBean;
import com.example.mykuangjia.persenter.login.RegisterPersenter;

import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<IBaseView, RegisterConstract.Persenter>
        implements RegisterConstract.View {
    private EditText mEditUsername;
    private EditText mEditPw1;
    private EditText mEditPw2;
    private EditText mEditVerify;
    private ImageView mImgVerify;
    private LinearLayout mLayoutList;
    private Button mBtnRegister;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;

    }

    @Override
    protected void initView() {
        mEditUsername = findViewById(R.id.edit_username);
        mEditPw1 = findViewById(R.id.edit_pw1);
        mEditPw2 = findViewById(R.id.edit_pw2);
        mEditVerify = findViewById(R.id.edit_verify);
        mImgVerify = findViewById(R.id.img_verify);
        mLayoutList = findViewById(R.id.layout_list);
        mBtnRegister = findViewById(R.id.btn_register);
    }

    @Override
    protected void initData() {
        persenter.getVerify();
    }

    @Override
    protected RegisterConstract.Persenter createPersenter() {
        return new RegisterPersenter();
    }

    @Override
    public void getVerifyReturn(VerifyBean result) {
        updateVerify(result);
    }
    @OnClick({R.id.img_verify, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_verify:
                persenter.getVerify();
                break;
            case R.id.btn_register:
                break;
        }
    }
    private void updateVerify(VerifyBean bean){
        Glide.with(this).load(bean.getData().getImg()).into(mImgVerify);
    }
}
