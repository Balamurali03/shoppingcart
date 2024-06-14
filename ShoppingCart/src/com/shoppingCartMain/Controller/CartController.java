package com.shoppingCartMain.Controller;

import java.util.Scanner;

import com.shoppingCartMain.FilterModule.ProductFilter;
import com.shoppingCartMain.ModuleFunctions.BuyerOption;

public class CartController {

	static Scanner sc = new Scanner(System.in);
	BuyerOption buyerOption= new BuyerOption();
	ProductFilter ProductFilter = new ProductFilter();
	public String fromAllProduct() {
		System.out.println("Enter the product Id's and seperate with comma (,) ");
		String id= sc.next();
		System.out.println("Enter the userId ");
		int uid= sc.nextInt();
		String result=buyerOption.fromAllProduct(id,uid);	
		return result;
	}
	public String selective() {
		
		System.out.println("Select the Category you want");
		System.out.println(ProductFilter.filterAllCategory().toString());
		String category =sc.next();
		System.out.println(ProductFilter.filterOnCategory(category).toString());
		String type =sc.next();
		System.out.println(ProductFilter.filterOnProductType(type).toString());
		String brand =sc.next();
		System.out.println(ProductFilter.filterOnBrand(brand).toString());
		System.out.println("Enter the product Id's and seperate with comma (,) ");
		String id= sc.next();
		System.out.println("Enter the userId ");
		int uid= sc.nextInt();
		String result=buyerOption.fromAllProduct(id,uid);	
		return result;
	}
}
