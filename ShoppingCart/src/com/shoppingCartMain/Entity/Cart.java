package com.shoppingCartMain.Entity;

public class Cart {
	
	private int cartid;
	private int userid;
	private int productid;
	public Cart() {
		super();
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public Cart(int cartid, int userid, int productid) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.productid = productid;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", userid=" + userid + ", productid=" + productid + "]";
	}
	
}
