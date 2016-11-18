package com.voler.myapplication.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.jess.arms.utils.DataHelper;
import com.voler.myapplication.R;
import com.voler.myapplication.adapter.FakeAdapter;
import com.voler.myapplication.db.PasswordService;
import com.voler.myapplication.mvp.model.entity.PasswordEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/26.
 */
public class RealMainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.lv_fake)
    ListView lvFake;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    private  List<PasswordEntity> mList = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_main);
        ButterKnife.bind(this);
        tvTitle.setText("列表");
        FakeAdapter fakeAdapter = new FakeAdapter(this);
        lvFake.setAdapter(fakeAdapter);
        String allPassword = DataHelper.getPassword(this, "pwdArray");
        JSONArray jsonArray = JSONArray.parseArray(allPassword);

        PasswordService passwordService = new PasswordService(this);
        mList = passwordService.getScrollData(0, (int) (passwordService.getCount()-1));
        fakeAdapter.notifyDataSetChanged(1, mList);
        lvFake.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetailActivity.class);
       PasswordEntity password  = mList.get(position);
        intent.putExtra("pid", password.getPid());
        startActivity(intent);
    }

    @OnClick(R.id.tv_right)
    public void onClick() {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("pid", "");
        startActivity(intent);
    }
}
