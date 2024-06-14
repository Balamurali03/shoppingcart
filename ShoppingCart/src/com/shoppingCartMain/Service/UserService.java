package com.shoppingCartMain.Service;

import java.util.List;

import com.shoppingCartMain.Entity.User;

public interface UserService {

	public boolean Signup(User user);
	public User Login(String email, String password);
	public boolean Logout(String email);
	public List<User> viewAllUser();
}
