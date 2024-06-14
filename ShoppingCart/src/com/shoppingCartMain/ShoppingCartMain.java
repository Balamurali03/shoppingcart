package com.shoppingCartMain;

import java.util.Scanner;

import com.shoppingCartMain.Controller.UserController;
import com.shoppingCartMain.Entity.User;
import com.shoppingCartMain.ModuleFunctions.LoginFunction;
import com.shoppingCartMain.Service.InvoiceService;
import com.shoppingCartMain.Service.InvoiceServiceImpl;

public class ShoppingCartMain {

	 static Scanner sc;
	public static void main(String[] args) {
		
		UserController controller = new UserController();
		InvoiceService service = new InvoiceServiceImpl();
		sc = new Scanner(System.in);
		boolean value = true;
		while (value == true) {
			System.out.println("Hello user trigger the function from the list \n 1. Register \n 2. Login "
					+ "\n 3. GetAllData \n 4. Invoice \n 5. Logout");
			String trigger = sc.next();
					trigger = trigger.toLowerCase();
			switch (trigger) {
			case "register":
				System.out.println(controller.register());
				break;
			case "login":
				User user = controller.login();
				if(user != null) {
					System.out.println("The Login details are : " +user.toString());
					new LoginFunction().loginFunction();
					
				} else {
					System.out.println("Login unsucessful");
				}
				System.out.println();
				break;
			case "getalldata":
				System.out.println(controller.view());
				break;
			case "invoice":
				System.out.println("Enter user id");
				System.out.println(service.generateInvoice(sc.nextInt()));
				break;
			case "logout":
				System.out.println(controller.logout());
				break;
				default :
					System.out.println("Write something from the list without spelling mistake ");
			}
		}
	}

}
