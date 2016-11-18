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
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(2500);
                if ("1".equals(DataHelper.getStringSF(SplashActivity.this, "is_first"))) {
                    startActivity(new Intent(SplashActivity.this, NewActivity.class));
                } else {
                    DataHelper.SetStringSF(SplashActivity.this, "is_first", "1");
                    startActivity(new Intent(SplashActivity.this, NewActivity.class));
                }
                finish();
            }
        }.start();
        String password = "123456";
        String seed = "123456";
        String encryptAES = null;
        AES.test1();
        try {
            encryptAES = StringUtil.encryptAES(seed, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, encryptAES, Toast.LENGTH_SHORT).show();
        String decryptAES = null;
        try {
            Log.i("-----------", "onCreate: ");
            decryptAES = StringUtil.decryptAES(seed, encryptAES);
            Log.i("-----------", decryptAES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, decryptAES, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
