package com.voler.myapplication.mvp.ui.activity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jess.arms.utils.DataHelper;
import com.voler.myapplication.R;
import com.voler.myapplication.util.AES;
import com.voler.myapplication.util.StringUtil;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/24.
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SystemClock.sleep(500);
        if ("1".equals(DataHelper.getStringSF(SplashActivity.this, "is_first"))) {
            if ("1".equals(DataHelper.getStringSF(SplashActivity.this, "is_set_password"))) {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
            }
        } else {
            DataHelper.SetStringSF(SplashActivity.this, "is_first", "1");
            startActivity(new Intent(SplashActivity.this, NewActivity.class));
        }

        finish();

    }

}
