package com.jiaqiang.waiterclient.entity;

public class Dishes {

	private int _id;
	private int no;// ��ʽ���
	private String dishesName;// �˵�����
	private String dishesCategory;// �˵����
	private double dishesUnitPrice;// ��ʽ�۸�
	private String photo;// ��ʽͼƬ
	private String dishesNotice;// ��ʽ����
	private String dishesUnit;// ��ʽ��λ
	private int dishesNum;//����
	

	public int getDishesNum() {
		return dishesNum;
	}

	public void setDishesNum(int dishesNum) {
		this.dishesNum = dishesNum;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDishesName() {
		return dishesName;
	}

	public void setDishesName(String dishesName) {
		this.dishesName = dishesName;
	}

	public String getDishesClass() {
		return dishesCategory;
	}

	public void setDishesClass(String dishesClass) {
		this.dishesCategory = dishesClass;
	}

	

	public String getDishesCategory() {
		return dishesCategory;
	}

	public void setDishesCategory(String dishesCategory) {
		this.dishesCategory = dishesCategory;
	}

	public double getDishesUnitPrice() {
		return dishesUnitPrice;
	}

	public void setDishesUnitPrice(double dishesUnitPrice) {
		this.dishesUnitPrice = dishesUnitPrice;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDishesNotice() {
		return dishesNotice;
	}

	public void setDishesNotice(String dishesNotice) {
		this.dishesNotice = dishesNotice;
	}

	public String getDishesUnit() {
		return dishesUnit;
	}

	public void setDishesUnit(String dishesUnit) {
		this.dishesUnit = dishesUnit;
	}

}
