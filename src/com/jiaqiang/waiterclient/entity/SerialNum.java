package com.jiaqiang.waiterclient.entity;

public class SerialNum {

	private String serialNum;// �˵���ˮ��
	private boolean state;// �˵���״̬:true��ʾ�Ѿ������ˣ�false��ʾδ����

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
