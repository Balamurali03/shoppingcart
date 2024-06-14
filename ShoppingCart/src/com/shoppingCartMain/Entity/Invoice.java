package com.shoppingCartMain.Entity;

public class Invoice {
	private int id;
	private String invoice;
	public Invoice(int id, String invoice) {
		super();
		this.id = id;
		this.invoice = invoice;
	}
	public Invoice() {
		super();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invoice=" + invoice + "]";
	}
	
}
