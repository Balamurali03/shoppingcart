package com.shoppingCartMain.Controller;

import java.util.List;
import java.util.Scanner;

import com.shoppingCartMain.Entity.ProductList;
import com.shoppingCartMain.Service.ProductService;
import com.shoppingCartMain.Service.ProductServiceImpl;

public class ProductController {
	ProductService service= new ProductServiceImpl();
	private static Scanner sc = new Scanner(System.in);
	
	public String addProduct() {
		ProductList product = new ProductList();
		System.out.println("Enter signup Details");
		System.out.println("Enter Agegroup");
		product.setAgegroup(sc.next());
		System.out.println("Enter Brand");
		product.setBrand(sc.next());
		System.out.println("Enter Category");
		product.setCategory(sc.next());
		System.out.println("Enter Color");
		product.setColor(sc.next());
		System.out.println("Enter Gender");
		product.setGender(sc.next());
		System.out.println("Enter Name");
		product.setName(sc.next());
		System.out.println("Enter Price ");
		product.setPrice(sc.nextDouble());
		System.out.println("Enter Producttype ");
		product.setProducttype(sc.next());
		System.out.println("Enter UserId ");
		product.setUser(sc.nextInt());
		if(service.addProduct(product)) {
			return "Product added Sucessfully";
		} else {
			return "Product is not added Sucessfully";
		}
	}
	
	public String DeleteProduct() {
		System.out.println("Enter Product Id");
		int id = sc.nextInt();
		if(service.deleteProduct(id)) {
			return "Product deleted Sucessfully";
		} else {
			return "Product is not deleted Sucessfully";
		}
	}
	
	public String getAllProducts() {
		List<ProductList> allProducts = service.getProductList();
		if(allProducts.size()>0) {
			return allProducts.toString();
		} else {
			return "NO products to show";
		}
	}

}
