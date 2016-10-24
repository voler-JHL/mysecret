package com.voler.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.voler.myapplication.R;

import java.util.Map;

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
        ImageView iv_avatar = viewHolder.getView(R.id.iv_avatar);
        TextView tv_name = viewHolder.getView(R.id.tv_name);
        TextView tv_password = viewHolder.getView(R.id.tv_password);

        iv_avatar.setImageResource(R.drawable.avatar);
        Map.Entry<String, ?> entry = (Map.Entry<String, ?>) data.get(position);
        tv_name.setText(entry.getKey());
        tv_password.setText((String) entry.getValue());
        return viewHolder.getConverView();
    }
}
