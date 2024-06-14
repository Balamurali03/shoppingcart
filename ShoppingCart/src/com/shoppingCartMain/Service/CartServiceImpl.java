package com.shoppingCartMain.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shoppingCartMain.DataBase.DatabaseConnection;
import com.shoppingCartMain.Entity.Cart;

public class CartServiceImpl implements CartService {

	@Override
	public boolean addCart(Cart cart) {
		
		String query = "INSERT INTO cart (userid, productid) VALUES (?, ?)";
		boolean value = false;
		
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, cart.getUserid());
			statement.setInt(2, cart.getProductid());
			
			int reg = statement.executeUpdate();
			if (reg == 1) {
				value = true;
			}
			
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return value;
	}

}
