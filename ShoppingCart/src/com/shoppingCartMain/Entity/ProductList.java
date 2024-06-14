package com.shoppingCartMain.Entity;

public class ProductList {
	private int productid;
	private String category;
	private String producttype;
	private String name;
	private String brand;
	private String gender;
	private String agegroup;
	private String color;
	private double price;
	private int userid;
	
	public ProductList() {
		super();
	}

	public ProductList(int productid, String category, String producttype, String name, String brand, String gender,
			String agegroup, String color, double price, int userid) {
		super();
		this.productid = productid;
		this.category = category;
		this.producttype = producttype;
		this.name = name;
		this.brand = brand;
		this.gender = gender;
		this.agegroup = agegroup;
		this.color = color;
		this.price = price;
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "ProductList [id=" + productid + ", category=" + category + ", producttype=" + producttype + ", name=" + name
				+ ", brand=" + brand + ", gender=" + gender + ", agegroup=" + agegroup + ", color=" + color + ", price="
				+ price + ", user=" + userid + "]";
	}

	public int getId() {
		return productid;
	}

	public void setId(int id) {
		this.productid = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(String agegroup) {
		this.agegroup = agegroup;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUser() {
		return userid;
	}

	public void setUser(int user) {
		this.userid = user;
	}

	
}
