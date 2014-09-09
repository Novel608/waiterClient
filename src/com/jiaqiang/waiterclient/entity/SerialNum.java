package com.jiaqiang.waiterclient.entity;

public class SerialNum {

	private String serialNum;// 账单流水号
	private boolean state;// 账单的状态:true表示已经结完账，false表示未结账

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

}
