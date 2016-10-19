package com.voler.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.voler.myapplication.R;

/**
 * 妈妈生活圈
 * 三尺春光驱我寒，一生戎马为长安 -- 韩经录
 * Created by voler on 2016/8/31.
 */
public class FakeAdapter extends MyBaseAdapter{

    public FakeAdapter(Context context) {
        mContext=context;
    }

    @Override
    protected View getMyView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(mContext, convertView, parent, R.layout.item_fake, position);
        ImageView iv_avatar = viewHolder.getView(R.id.iv_avatar);
        TextView tv_name = viewHolder.getView(R.id.tv_name);

        iv_avatar.setImageResource(R.drawable.avatar);
        tv_name.setText("名字");
//        data.get()
        return viewHolder.getConverView();
    }
}
