package com.misszhu.xiaog.base;
/**
 *====================================================
 *	@Copyright (C) 2012-2013 杭州领图信息科技有限公司
 *	@All rights reserved
 *	@filename :MsgData.java
 * 	@date	2013-4-16
 * 	@time	下午2:48:30
 * 	@author 许度庆 
 * 	@description：消息数据实体类
 *
 *@---------------代码维护与版本信息---------------------------
 * 			@版本：V1.0  编写人：许度庆  描述：第一次创建 
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
 