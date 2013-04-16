package com.misszhu.xiaog;

import java.util.ArrayList;
import java.util.List;

import com.misszhu.xiaog.base.GetHttpServer;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView mListView_Content;
	EditText mEditText_Send;
	Button mButton_Send;
	private final String ACTION_NAME = "发送广播";
	private List<String> msgList;
	ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView_Content = (ListView) findViewById(R.id.Main_List_Content);
		mEditText_Send = (EditText) findViewById(R.id.Main_Edit_Send);
		mButton_Send = (Button) findViewById(R.id.Main_Button_Sand);
		msgList = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1, msgList);
		mListView_Content.setAdapter(adapter);
		// 激情过后失去当初的那份信任，相信不管怎样此人都会给你带来幸福。
		registerBoradcastReceiver();
		InitUI();
	}

	/**
	 * 初始化界面控件
	 */
	private void InitUI() {

		mButton_Send.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GetHttpServer getHttpServer = new GetHttpServer(
						MainActivity.this);
				String sendStr = mEditText_Send.getText().toString();
				getHttpServer.SendMsg(sendStr);

			}
		});
	}

	/**
	 * 广播接收类
	 */
	private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String action = intent.getAction();
			String msg = intent.getStringExtra("webData");
			if (action.equals(ACTION_NAME)) {
				Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG)
						.show();
				msgList.add(msg);
				adapter.notifyDataSetChanged();
				mListView_Content.setSelection(adapter.getCount()-1);
			}

		}
	};

	public void registerBoradcastReceiver() {
		IntentFilter myIntentFilter = new IntentFilter();
		myIntentFilter.addAction(ACTION_NAME);
		// 注册广播
		registerReceiver(mBroadcastReceiver, myIntentFilter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
