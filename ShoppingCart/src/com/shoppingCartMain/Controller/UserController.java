package com.shoppingCartMain.Controller;

import java.util.List;
import java.util.Scanner;

import com.shoppingCartMain.Entity.User;
import com.shoppingCartMain.Service.UserService;
import com.shoppingCartMain.Service.UserServiceImpl;

public class UserController {
	
	UserService service = new UserServiceImpl();
	private static Scanner sc = new Scanner(System.in);

	public String register() {
		User user = new User();
		System.out.println("Enter signup Details");
		System.out.println("Enter Name");
		user.setName(sc.nextLine());
		System.out.println("Enter Email");
		user.setEmail(sc.nextLine());
		System.out.println("Enter Password");
		user.setPassword(sc.nextLine());
		System.out.println("Enter Mobile Number");
		user.setPhno(sc.nextLong());
		System.out.println("Enter Gender");
		user.setGender(sc.nextLine());
		System.out.println("Enter Doorno");
		user.setDoorno(sc.nextLine());
		System.out.println("Enter Streetno ");
		user.setStreetno(sc.nextLine());
		System.out.println("Enter city ");
		user.setCity(sc.nextLine());
		System.out.println("Enter Area ");
		user.setArea(sc.nextLine());
		System.out.println("Enter State ");
		user.setState(sc.nextLine());
		System.out.println("Enter Pincode ");
		user.setPincode(sc.nextInt());
		
		if(service.Signup(user)) {
			return "User Signup Sucessful";
		} else {
			return "User Signup is not Sucessful";
		}
	}
	
	public User login() {
		
		System.out.println("Enter Login Details");
		System.out.println("Enter Email");
		String email = sc.next();
		System.out.println("Enter Password");
		String password=sc.next();
		User user = service.Login(email, password);
		return user;
	}
	
	public String view() {
		System.out.println("All user details");
		List<User> allData = service.viewAllUser();
		if(allData.size()>0) {
			return allData.toString();
		} else {
			return "NO Data list found";
		}
	}
	
	public String logout() {
		System.out.println("Enter Logout Credentials");
		System.out.println("Enter Email");
		String email = sc.next();
		if(service.Logout(email)) {
			return "User Loggedout Sucessfully";
		} 
		else {

			return "User not Loggedout Sucessfully";
		}
		
	}
}
