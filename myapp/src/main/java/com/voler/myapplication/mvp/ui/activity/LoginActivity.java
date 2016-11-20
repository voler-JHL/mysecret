package com.voler.myapplication.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jess.arms.utils.DataHelper;
import com.jess.arms.utils.UiUtils;
import com.voler.myapplication.R;
import com.voler.myapplication.util.AES;
import com.voler.myapplication.util.StringUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.voler.myapplication.util.StringUtil.sha2;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/10/14.
 */

public class LoginActivity extends AppCompatActivity {


    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.tv_login)
    TextView tvLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_login)
    public void onClick() {
        String password = etPassword.getText().toString().trim();
        String myPassword = StringUtil.sha2(StringUtil.sha2(password+StringUtil.sha2(password)) + sha2(password + StringUtil.salt));
        if (myPassword.equals(DataHelper.getStringSF(this, "password"))) {
            Intent intent = new Intent(this, RealMainActivity.class);
            startActivity(intent);
            AES.setKey(StringUtil.sha2(password+StringUtil.sha2(password)+StringUtil.salt).substring(0,15)+"");
            finish();
        }else {
            Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
        }
    }
}
