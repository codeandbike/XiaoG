package com.misszhu.xiaog.base;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @date 2013-4-15
 * @time 下午11:32:52
 * @author 许度庆
 * 
 *         类说明:web服务处理类
 */
public class GetHttpServer {

	String path;
	private final String ACTION_NAME = "发送广播";
	private Context mContext;

	public GetHttpServer(Context context) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	/**
	 * 发送消息
	 * 
	 * @return
	 */
	public boolean SendMsg(String sendString) {
		String sendData="";
		try {
			sendData = URLEncoder.encode(sendString, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		path = "http://qqapi.sdapp.cn/simsimi/?Msg="+sendData+"&Type=1&Key=658782";
		new Thread(runnable).start();
		return true;
	}

	/**
	 * 开线程加载网络数据 ps： 4.0不支持在主线程加载网络数据
	 */
	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String html;
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();

				conn.setRequestMethod("GET");
				conn.setConnectTimeout(5 * 1000);
				InputStream inputStream = conn.getInputStream();
				byte[] data = readInputStream(inputStream);
				html = new String(data);

				Intent mIntent = new Intent(ACTION_NAME);
				mIntent.putExtra("webData", html);
				// 发送广播
				mContext.sendBroadcast(mIntent);

			} catch (Exception e) {
				// TODO: handle exception
				Log.e("请求错误：", e.getMessage());
			}

		}
	};

	// 读取输入流中的数据，返回字节数组byte[]
	public byte[] readInputStream(InputStream inStream) throws Exception {
		// 此类实现了一个输出流，其中的数据被写入一个 byte 数组
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// 字节数组
		byte[] buffer = new byte[1024];
		int len = 0;
		// 从输入流中读取一定数量的字节，并将其存储在缓冲区数组buffer 中
		while ((len = inStream.read(buffer)) != -1) {
			// 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		// toByteArray()创建一个新分配的 byte 数组。
		return outStream.toByteArray();
	}

}
