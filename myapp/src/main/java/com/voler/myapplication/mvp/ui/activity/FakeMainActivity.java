package com.voler.myapplication.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.voler.myapplication.R;
import com.voler.myapplication.activity.DetaActivity;
import com.voler.myapplication.activity.DetailActivity;
import com.voler.myapplication.adapter.FakeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/26.
 */
public class FakeMainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @Bind(R.id.lv_fake)
    ListView lvFake;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_main);
        ButterKnife.bind(this);
        FakeAdapter fakeAdapter = new FakeAdapter(this);
        lvFake.setAdapter(fakeAdapter);
        List list = new ArrayList();
        list.add(0, "jk");
        list.add(1, "jk");
        list.add(2, "jk");
        list.add(3, "jk");
        list.add(4, "jk");
        list.add(5, "jk");
        list.add(6, "jk");
        fakeAdapter.notifyDataSetChanged(1, list);
        lvFake.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("","");
        startActivity(intent);
    }
}
