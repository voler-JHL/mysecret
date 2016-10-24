package com.voler.myapplication.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jess.arms.utils.DataHelper;
import com.voler.myapplication.R;
import com.voler.myapplication.activity.DetaActivity;
import com.voler.myapplication.adapter.FakeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Bind(R.id.tv_add)
    TextView tvAdd;
    private List mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_main);
        ButterKnife.bind(this);
        FakeAdapter fakeAdapter = new FakeAdapter(this);
        lvFake.setAdapter(fakeAdapter);
        mList = new ArrayList();
        Map<String, ?> allPassword = DataHelper.getAllPassword(this);
        int i = 0;
        for (Map.Entry<String, ?> entry : allPassword.entrySet()) {
            mList.add(i, entry);
            i++;
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        fakeAdapter.notifyDataSetChanged(1, mList);
        lvFake.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetailActivity.class);
        Map.Entry<String, ?> entry = (Map.Entry<String, ?>) mList.get(position);
        intent.putExtra("name", entry.getKey());
        startActivity(intent);
    }

    @OnClick(R.id.tv_add)
    public void onClick() {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("name", "");
        startActivity(intent);
    }
}
