package com.voler.myapplication.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.utils.DataHelper;
import com.voler.myapplication.R;
import com.voler.myapplication.util.AES;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/26.
 */
public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.iv_avatar_big)
    ImageView ivAvatarBig;
    @Bind(R.id.tv_update)
    TextView tvUpdate;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_pwd)
    EditText etPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        etName.setText(name);
        etPwd.setText(AES.decode(DataHelper.getPassword(this, name)));
    }

    @OnClick({R.id.iv_avatar_big, R.id.tv_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar_big:
                break;
            case R.id.tv_update:
                break;
        }
    }
}
