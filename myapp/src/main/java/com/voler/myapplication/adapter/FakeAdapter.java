package com.voler.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.voler.myapplication.R;
import com.voler.myapplication.util.AES;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.Bind;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/31.
 */
public class FakeAdapter extends MyBaseAdapter {


    public FakeAdapter(Context context) {
        mContext = context;
    }

    @Override
    protected View getMyView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(mContext, convertView, parent, R.layout.item_fake, position);
        TextView tv_name = viewHolder.getView(R.id.tv_name);
        TextView tv_account = viewHolder.getView(R.id.tv_account);
        TextView tv_password = viewHolder.getView(R.id.tv_password);

        Map.Entry<String, ?> entry = (Map.Entry<String, ?>) data.get(position);
        tv_name.setText(entry.getKey());
        Set<String> value = (Set<String>) entry.getValue();
        List<String> list=new ArrayList<>();
        for (String str : value) {
            list.add(str);
        }
        tv_account.setText(list.get(1));
        tv_password.setText(AES.decode(list.get(0)));
        return viewHolder.getConverView();
    }
}
