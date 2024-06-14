package com.shoppingCartMain.ModuleFunctions;

import java.util.Scanner;

import com.shoppingCartMain.ShoppingCartMain;
import com.shoppingCartMain.Controller.CartController;
import com.shoppingCartMain.Controller.ProductController;
import com.shoppingCartMain.Controller.UserController;

public class BuyFunctions {
	private static Scanner sc ;
	
	public void buyFunction() {
		
		sc = new Scanner(System.in);
		UserController controller = new UserController();
		ProductController productController = new ProductController();
		CartController CartController= new CartController();
		boolean value = true;
		while (value == true) {
			System.out.println("Hello user trigger the function from the list \n 1. AllProducts \n 2. Selective "
					+ "\n 3. Logout \n 4. Back ");
			String trigger = sc.next();
					trigger = trigger.toLowerCase();
			switch (trigger) {
			case "allproducts":
				System.out.println(productController.getAllProducts());
				System.out.println(CartController.fromAllProduct());
				break;
	        case "selective":
	        	System.out.println(CartController.selective());
				break;
				
			case "logout":
				System.out.println(controller.logout());
				value=false;
				ShoppingCartMain.main(null);
				break;
			case "back":
				value= false;
				break;
				default :
					System.out.println("Write something from the list without spelling mistake ");
			}}
	}
	
	
}
