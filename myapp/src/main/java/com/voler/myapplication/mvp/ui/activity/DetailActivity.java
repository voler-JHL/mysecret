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
import com.voler.myapplication.app.WEApplication;
import com.voler.myapplication.db.PasswordService;
import com.voler.myapplication.listener.OnActionViewClickListener;
import com.voler.myapplication.mvp.model.entity.PasswordEntity;
import com.voler.myapplication.util.AES;
import com.voler.myapplication.util.StringUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.password;
import static android.R.id.list;

/**
 * 妈妈生活圈yd
 * 妈妈生活圈y
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

    private String pid;
    private boolean isEdit = false;
    private PasswordService passwordService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        tvTitle.setText("详情");
        tvRight.setText("删除");
        passwordService = new PasswordService(this);
        Bundle extras = getIntent().getExtras();
        pid = extras.getString("pid");
        if (pid == null || "".equals(pid)) {
            setCanEdit();
        } else {
            PasswordEntity passwordEntity = passwordService.find(pid);
            etName.setText(passwordEntity.getName());
            etAccount.setText(passwordEntity.getAccount());
            etPwd.setText(AES.decode(passwordEntity.getPwd()));
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
        tvUpdate.setText("完 成");
        isEdit = true;
    }


    @OnClick({R.id.tv_right, R.id.tv_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_right:
                passwordService.delete(pid);
                finish();
                break;
            case R.id.tv_update:
                if (isEdit) {
                    String password = AES.encode(etPwd.getText().toString().trim());
                    String name = etName.getText().toString().trim();
                    String account = etAccount.getText().toString().trim();
                    PasswordEntity passwordEntity = new PasswordEntity(pid, name, account, password);
                    if (pid == null || "".equals(pid)) {
                        passwordService.save(passwordEntity);
                    } else {
                        passwordService.update(passwordEntity);
                    }
                    finish();
                } else {
                    setCanEdit();
                }
                break;
        }
    }
}
