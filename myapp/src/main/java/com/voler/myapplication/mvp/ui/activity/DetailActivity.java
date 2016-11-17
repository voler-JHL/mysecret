package com.voler.myapplication.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jess.arms.utils.DataHelper;
import com.voler.myapplication.R;
import com.voler.myapplication.listener.OnActionViewClickListener;
import com.voler.myapplication.util.AES;
import com.voler.myapplication.util.StringUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/26.
 */
public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.tv_update)
    TextView tvUpdate;
    @Bind(R.id.et_name)
    EditText etName;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.et_account)
    EditText etAccount;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_right)
    TextView tvRight;

    private String mName;
    private boolean isEdit = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        tvTitle.setText("详情");
        tvRight.setText("删除");
        Bundle extras = getIntent().getExtras();
        mName = extras.getString("name");
        if (mName == null || "".equals(mName)) {
            setCanEdit();
        } else {
            etName.setText(mName);
            Set<String> password = DataHelper.getPassword(this, mName);
            List<String> list = new ArrayList<>();
            for (String str : password) {
                list.add(str);
            }
            etAccount.setText(list.get(0));
            etPwd.setText(AES.decode(list.get(1)));
        }
        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String editable = etPwd.getText().toString();
                String str = StringUtil.noChineseFilter(editable);
                if (!editable.equals(str)) {
                    etPwd.setText(str);
                    //设置新的光标所在位置
                    etPwd.setSelection(str.length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setCanEdit() {
        etPwd.setEnabled(true);
        etName.setEnabled(true);
        etAccount.setEnabled(true);
        tvRight.setVisibility(View.GONE);
        tvUpdate.setText("完成");
        isEdit = true;
    }

    private void setNotEdit() {
        etPwd.setEnabled(false);
        etName.setEnabled(false);
        etAccount.setEnabled(false);
        tvRight.setVisibility(View.VISIBLE);
        tvUpdate.setText("修改");
        isEdit = false;
    }


    @OnClick({R.id.tv_right, R.id.tv_update})
    public void onClick(View view) {
        Toast.makeText(this, "nfidjasf", Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.tv_right:
                DataHelper.removePassword(this, mName);
                break;
            case R.id.tv_update:
                if (isEdit) {
                    setNotEdit();
                    String password = etPwd.getText().toString().trim();
                    String name = etName.getText().toString().trim();
                    String account = etAccount.getText().toString().trim();
                    Set<String> set = new HashSet<>();
                    set.add(account);
                    set.add(AES.encode(password));
                    DataHelper.setPassword(this, name, set);
                } else {
                    setCanEdit();
                }
                Toast.makeText(this, "nfidjasf", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
