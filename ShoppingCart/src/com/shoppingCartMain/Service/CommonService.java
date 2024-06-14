package com.shoppingCartMain.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shoppingCartMain.DataBase.DatabaseConnection;
import com.shoppingCartMain.Entity.User;

public class CommonService {
	
	// For User Service

	public static int StatusUpdate(String email,String status) {
		
		String updateStatus = "UPDATE users SET status = ? WHERE email = ?";
		int updateResultSetCode=0;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement updateStatement = connection.prepareStatement(updateStatus);
			updateStatement.setString(1, status);
			updateStatement.setString(2, email);
			updateResultSetCode= updateStatement.executeUpdate();
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		return updateResultSetCode;
	}
	
	public static User Search(String email) {
		String query = "SELECT * FROM users WHERE email = ? AND status = 'ACTIVE'";
		User user = null;

		try (Connection connection = DatabaseConnection.getConnection()){
				PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				 int id = resultSet.getInt("userid");
				 String name = resultSet.getString("name");
				 String password = resultSet.getString("password");
				 String gender = resultSet.getString("gender");
				 String doorno = resultSet.getString("doorno");
				 String streetno = resultSet.getString("streetno");
				 String city = resultSet.getString("city");
				 String area = resultSet.getString("area");
				 String state = resultSet.getString("state");
				 int pincode = resultSet.getInt("pincode");
				 long phno = resultSet.getLong("phno");
				 String status = resultSet.getString("status");

				 user= new User(id, name, email, password, gender, doorno, streetno, city, area, state, pincode, phno, status, null, null);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}

		return user;
	}
	
	// For Product Service
	public static boolean checkUser(int userid) {
		String query = "SELECT * FROM users WHERE userid = ? AND status = 'ACTIVE'";
		boolean value = false;
		
		try (Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);

		statement.setInt(1, userid);
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			value = true;
		}
		
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
		return value;
	}
	
	public static boolean checkStatus(int id) {
		String query = "SELECT * FROM users WHERE userid = (SELECT userid FROM product WHERE productid = ? ) AND status = 'ACTIVE'";
		boolean value = false;
		try (Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);

		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			value = true;
		}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
		return value;
	}
}
