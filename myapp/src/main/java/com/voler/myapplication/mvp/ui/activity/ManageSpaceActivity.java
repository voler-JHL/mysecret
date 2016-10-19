package com.voler.myapplication.mvp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/10/19.
 */

public class ManageSpaceActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this,"已优化",Toast.LENGTH_LONG).show();
        finish();

    }// onCreate
}
