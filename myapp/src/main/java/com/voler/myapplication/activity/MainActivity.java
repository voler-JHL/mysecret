package com.voler.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.voler.myapplication.R;
import com.voler.myapplication.mvp.ui.activity.FakeMainActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.tv_button1)
    TextView tvButton1;
    @Bind(R.id.tv_button2)
    TextView tvButton2;
    @Bind(R.id.tv_button3)
    TextView tvButton3;
    @Bind(R.id.tv_button4)
    TextView tvButton4;
    @Bind(R.id.tv_button5)
    TextView tvButton5;
    @Bind(R.id.tv_button6)
    TextView tvButton6;
    @Bind(R.id.tv_button7)
    TextView tvButton7;
    @Bind(R.id.tv_button8)
    TextView tvButton8;
    @Bind(R.id.tv_button9)
    TextView tvButton9;
    @Bind(R.id.bt_confirm)
    Button btConfirm;
    private String realPassWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        String pwd = etPwd.getText().toString().trim();
    }


    public void confirm(View view) {
        String pwd = etPwd.getText().toString().trim();
        if (!"".equals(pwd)) {
            startActivity(new Intent(this, FakeMainActivity.class));
            return;
        }
        if (realPassWord.equals("123")) {
            startActivity(new Intent(this, RealMainActivity.class));
        } else {
            realPassWord = "";
        }


    }

    @OnClick({R.id.tv_button1, R.id.tv_button2, R.id.tv_button3, R.id.tv_button4, R.id.tv_button5, R.id.tv_button6, R.id.tv_button7, R.id.tv_button8, R.id.tv_button9, R.id.bt_confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_button1:
                realPassWord += 1;
                Toast.makeText(getApplicationContext(), "11", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_button2:
                realPassWord += 2;
                break;
            case R.id.tv_button3:
                realPassWord += 3;
                break;
            case R.id.tv_button4:
                realPassWord += 4;
                break;
            case R.id.tv_button5:
                realPassWord += 5;
                break;
            case R.id.tv_button6:
                realPassWord += 6;
                break;
            case R.id.tv_button7:
                realPassWord += 7;
                break;
            case R.id.tv_button8:
                realPassWord += 8;
                break;
            case R.id.tv_button9:
                realPassWord += 9;
                break;
            case R.id.bt_confirm:
                String pwd = etPwd.getText().toString().trim();
                if (!"".equals(pwd)) {
                    startActivity(new Intent(this, FakeMainActivity.class));
                    return;
                }
                if (realPassWord.equals("123")) {
                    startActivity(new Intent(this, RealMainActivity.class));
                } else {
                    realPassWord = "";
                }
                break;
        }
    }
}
