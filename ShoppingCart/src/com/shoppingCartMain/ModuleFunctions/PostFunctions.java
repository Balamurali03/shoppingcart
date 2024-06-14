package com.shoppingCartMain.ModuleFunctions;

import java.util.Scanner;

import com.shoppingCartMain.ShoppingCartMain;
import com.shoppingCartMain.Controller.ProductController;
import com.shoppingCartMain.Controller.UserController;

public class PostFunctions {
	private static Scanner sc;
	
	public void postFunctions() {
	
	sc = new Scanner(System.in);
	UserController controller = new UserController();
	ProductController productController = new ProductController();
	boolean value = true;
	while (value == true) {
		System.out.println("Hello user trigger the function from the list \n 1. AddProduct \n 2. DeleteProduct "
				+ "\n 3. Logout \n 4. Back ");
		String trigger = sc.next();
				trigger = trigger.toLowerCase();
		switch (trigger) {
		case "addproduct":
			System.out.println(productController.addProduct());
			break;
        case "deleteproduct":
			System.out.println(productController.DeleteProduct());
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
