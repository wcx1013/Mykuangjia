package com.example.mykuangjia.ui.login;

import android.widget.Button;
import android.widget.EditText;

import com.example.mykuangjia.R;
import com.example.mykuangjia.base.BaseActivity;
import com.example.mykuangjia.interfaces.IBaseView;
import com.example.mykuangjia.interfaces.login.LoginConstract;
import com.example.mykuangjia.models.bean.UserBean;
import com.example.mykuangjia.persenter.login.LoginPersenter;
import com.example.mykuangjia.utils.SpUtils;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity<IBaseView, LoginConstract.Persenter> implements LoginConstract.View {
    private EditText mEditUsername;
    private EditText mEditPassword;
    private Button mBtnLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;

    }

    @Override
    protected void initView() {
        mEditUsername = findViewById(R.id.edit_username);
        mEditPassword = findViewById(R.id.edit_password);
        mBtnLogin = findViewById(R.id.btn_login);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected LoginConstract.Persenter createPersenter() {
        return new LoginPersenter();
    }

    @Override
    public void loginReturn(UserBean result) {
        //登录成功以后存入sp
        SpUtils.getInstance().setValue("token",result.getData().getToken());
    }
    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String nickname = mEditUsername.getText().toString();
        String password = mEditPassword.getText().toString();

        persenter.login(nickname,password);
    }
}
