package com.voler.myapplication.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

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
 * Created by voler on 2016/10/20.
 */

public class RegisterActivity extends AppCompatActivity {
    @Bind(R.id.et_input_password1)
    EditText etInputPassword1;
    @Bind(R.id.et_input_password2)
    EditText etInputPassword2;
    @Bind(R.id.tv_register)
    TextView tvRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_register)
    public void onClick() {
        String pd1 = etInputPassword1.getText().toString().trim();
        String pd2 = etInputPassword2.getText().toString().trim();
        if (pd1==null||"".equals(pd1)){
            UiUtils.makeText("请输入密码");
        }else if (!pd1.equals(pd2)){
            UiUtils.makeText("两次输入的密码不一致");
        }else {
            String myPassword = StringUtil.sha2(StringUtil.sha2(pd1+StringUtil.sha2(pd1)) + sha2(pd1 + StringUtil.salt));
            DataHelper.SetStringSF(this,"password",myPassword);
            DataHelper.SetStringSF(this, "is_set_password", "1");
            String key = StringUtil.sha2(pd1 + StringUtil.sha2(pd1) + StringUtil.salt).substring(0, 15) + "0";
            Log.i("-----",key);
            AES.setKey(key);
            Intent intent=new Intent(this,RealMainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
