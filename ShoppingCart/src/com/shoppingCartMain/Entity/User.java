package com.shoppingCartMain.Entity;

import java.util.List;

public class User {
	private int userid;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String doorno;
	private String streetno;
	private String city;
	private String area;
	private String state;
	private int pincode;
	private long phno;
	private String status;
	private List<Cart> cart;
	private List<ProductList> products;
	public User() {
		super();
	}
	public User(int userid, String name, String email, String password, String gender, String doorno, String streetno,
			String city, String area, String state, int pincode, long phno, String status, List<Cart> cart,
			List<ProductList> products) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.doorno = doorno;
		this.streetno = streetno;
		this.city = city;
		this.area = area;
		this.state = state;
		this.pincode = pincode;
		this.phno = phno;
		this.status = status;
		this.cart = cart;
		this.products = products;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", doorno=" + doorno + ", streetno=" + streetno + ", city=" + city + ", area=" + area
				+ ", state=" + state + ", pincode=" + pincode + ", phno=" + phno +  ", status=" + status + ", cart=" + cart + ", products="
				+ products + "]";
	}
	public int getId() {
		return userid;
	}
	public void setId(int id) {
		this.userid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStreetno() {
		return streetno;
	}
	public void setStreetno(String streetno) {
		this.streetno = streetno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public List<ProductList> getProducts() {
		return products;
	}
	public void setProducts(List<ProductList> products) {
		this.products = products;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
