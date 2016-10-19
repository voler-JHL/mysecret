package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.AppComponent;
import me.jessyan.mvparms.demo.mvp.contract.LoginContract;
import me.jessyan.mvparms.demo.mvp.model.api.Api;
import me.jessyan.mvparms.demo.mvp.presenter.LoginPersenter;
import me.jessyan.mvparms.demo.mvp.ui.common.WEActivity;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/10/14.
 */

public class LoginActivity extends WEActivity<LoginPersenter> implements LoginContract.View {


    @Bind(R.id.phone_num)
    EditText phoneNum;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.send_code)
    TextView sendCode;
    @Bind(R.id.login)
    TextView login;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_login, null, false);
    }

    @Override
    protected void initData() {
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killMyself() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.send_code, R.id.login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_code:

                break;
            case R.id.login:
                mPresenter.login(Api.LOGIN_ACTIVITY_USERLOGIN,phoneNum.getText().toString().trim(),password.getText().toString().trim(),"1");
                break;
        }
    }
}
