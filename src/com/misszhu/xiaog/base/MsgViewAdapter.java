package com.misszhu.xiaog.base;

import java.util.List;

import com.misszhu.xiaog.R;

import android.R.bool;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * ====================================================
 * 
 * @Copyright (C) 2012-2013 ������ͼ��Ϣ�Ƽ����޹�˾
 * @All rights reserved
 * @filename :MsgViewAdapter.java
 * @date 2013-4-16
 * @time ����1:39:07
 * @author �����
 * @description����Ϣ��ʾ������
 * 
 * @---------------����ά����汾��Ϣ---------------------------
 * @�汾��V1.0 ��д�ˣ������ ��������һ�δ���
 * 
 * 
 * @=====================================================
 */
public class MsgViewAdapter extends BaseAdapter {

	private Context mContext;
	private List<MsgData> msgList;
	private LayoutInflater mLayoutInflater;

	public MsgViewAdapter(Context context, List<MsgData> msgList) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.msgList = msgList;
		mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return msgList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		MsgData msgData = msgList.get(position);
		//if (convertView == null) {

			
			if (msgData.isComMsg()) {
				convertView = mLayoutInflater.inflate(
						R.layout.item_msgview_right, null);
			}else {
				convertView = mLayoutInflater.inflate(
						R.layout.item_msgview_left, null);
			}


			viewHolder = new ViewHolder();
			viewHolder.tvContent = (TextView) convertView
					.findViewById(R.id.tv_chatcontent);
			
			convertView.setTag(viewHolder);
//		} else {
//			viewHolder = (ViewHolder) convertView.getTag();
//		}


		viewHolder.tvContent.setText(msgData.getMsgString());

		return convertView;
	}

	static class ViewHolder {
		public TextView tvSendTime;
		public TextView tvUserName;
		public TextView tvContent;
		public boolean isComMsg = true;
	}

}
