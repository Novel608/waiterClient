package com.jiaqiang.waiterclient.entity;

public class Dishes {

	private int _id;
	private int no;// 菜式编号
	private String dishesName;// 菜单名称
	private String dishesCategory;// 菜单类别
	private double dishesUnitPrice;// 菜式价格
	private String photo;// 菜式图片
	private String dishesNotice;// 菜式描述
	private String dishesUnit;// 菜式单位
	private int dishesNum;//数量
	

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
