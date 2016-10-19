package com.voler.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.voler.myapplication.listener.OnActionViewClickListener;

import java.util.ArrayList;
import java.util.List;


/**
 * 迭代器基类 
 * @author yangshenghui
 *
 */
public abstract class MyBaseAdapter extends BaseAdapter {
	
	protected List data ;
	protected OnActionViewClickListener mListener;
	protected Context mContext;
	
	protected abstract View getMyView(int position, View convertView, ViewGroup parent) ;
		
	
	
	public MyBaseAdapter() {
		this.data = new ArrayList();
		mListener = new OnActionViewClickListener() {
			@Override
			public void onClick(View v) {}
		};
	}
	
	
	public List getData(){
		return data;
	}
	
	
	public void clearData(){
		data.clear();
	}
	
	
	/**
	 * 设置ActionView点击事件
	 * @param listener
	 */
	public void setOnActionViewClickListener(OnActionViewClickListener listener) {
		if(listener == null) {
			return;
		}
		this.mListener = listener;
	}
	
	
	/**
	 * 更新经验列表
	 */
	public void notifyDataSetChanged(int skipCount, List array) {
		if(array == null) {
			return;
		}
		synchronized (MyBaseAdapter.class) {
			if(skipCount <= 0) {
				this.data = array;
			} else {
				this.data.addAll(array);
			}
		}
		super.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		return getMyView(position , convertView , parent);
	}



}
