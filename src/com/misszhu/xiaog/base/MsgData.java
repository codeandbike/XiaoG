package com.misszhu.xiaog.base;
/**
 *====================================================
 *	@Copyright (C) 2012-2013 ������ͼ��Ϣ�Ƽ����޹�˾
 *	@All rights reserved
 *	@filename :MsgData.java
 * 	@date	2013-4-16
 * 	@time	����2:48:30
 * 	@author ����� 
 * 	@description����Ϣ����ʵ����
 *
 *@---------------����ά����汾��Ϣ---------------------------
 * 			@�汾��V1.0  ��д�ˣ������  ��������һ�δ��� 
 *
 *
 *@=====================================================
 */
public class MsgData {
	
	private String msgString;
	private boolean isComMsg = true;

	public String getMsgString() {
		return msgString;
	}

	public void setMsgString(String msgString) {
		this.msgString = msgString;
	}

	public boolean isComMsg() {
		return isComMsg;
	}

	
	public boolean getMsgType() {
        return isComMsg;
    }

    public void setMsgType(boolean isComMsg) {
    	this.isComMsg = isComMsg;
    }

}
 