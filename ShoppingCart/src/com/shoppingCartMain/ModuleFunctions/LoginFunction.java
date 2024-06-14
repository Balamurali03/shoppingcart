package com.shoppingCartMain.ModuleFunctions;

import java.util.Scanner;

import com.shoppingCartMain.Controller.UserController;

public class LoginFunction {
	private static Scanner sc ;
	public void loginFunction() {
		
		sc = new Scanner(System.in);
		UserController controller = new UserController();
		boolean value = true;
		while (value == true) {
			System.out.println("Hello user trigger the function from the list \n 1. Buy \n 2. Post "
					+ "\n 3. Logout \n 4. Back ");
			String trigger = sc.next();
					trigger = trigger.toLowerCase();
			switch (trigger) {
			case "buy":
				 new BuyFunctions().buyFunction();
				break;
            case "post":
            	new PostFunctions().postFunctions();
				break;
				
			case "logout":
				System.out.println(controller.logout());
				value=false;
				break;
			case "back":
				value= false;
				break;
				default :
					System.out.println("Write something from the list without spelling mistake ");
			}}
	}

}
