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
 * @time ����11:32:52
 * @author �����
 * 
 *         ��˵��:web��������
 */
public class GetHttpServer {

	String path;
	private final String ACTION_NAME = "���͹㲥";
	private Context mContext;

	public GetHttpServer(Context context) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	/**
	 * ������Ϣ
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
	 * ���̼߳����������� ps�� 4.0��֧�������̼߳�����������
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
				// ���͹㲥
				mContext.sendBroadcast(mIntent);

			} catch (Exception e) {
				// TODO: handle exception
				Log.e("�������", e.getMessage());
			}

		}
	};

	// ��ȡ�������е����ݣ������ֽ�����byte[]
	public byte[] readInputStream(InputStream inStream) throws Exception {
		// ����ʵ����һ������������е����ݱ�д��һ�� byte ����
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// �ֽ�����
		byte[] buffer = new byte[1024];
		int len = 0;
		// ���������ж�ȡһ���������ֽڣ�������洢�ڻ���������buffer ��
		while ((len = inStream.read(buffer)) != -1) {
			// ��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д��������
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		// toByteArray()����һ���·���� byte ���顣
		return outStream.toByteArray();
	}

}
