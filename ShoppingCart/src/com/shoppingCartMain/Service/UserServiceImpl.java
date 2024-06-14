package com.shoppingCartMain.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingCartMain.DataBase.DatabaseConnection;
import com.shoppingCartMain.Entity.User;

public class UserServiceImpl implements UserService {

	@Override
	public boolean Signup(User user) {

		String query = "INSERT INTO users (name, email, password, gender, doorno, streetno, "
				+ "city, area, state, pincode, phno, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		boolean value = false;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getGender());
			statement.setString(5, user.getDoorno());
			statement.setString(6, user.getStreetno());
			statement.setString(7, user.getCity());
			statement.setString(8, user.getArea());
			statement.setString(9, user.getState());
			statement.setInt(10, user.getPincode());
			statement.setLong(11, user.getPhno());
			statement.setString(12, "INACTIVE");

			int reg = statement.executeUpdate();
			if (reg == 1) {
				value = true;
			}

		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		return value;
	}

	@Override
	public User Login(String email, String password) {
		String query = "SELECT * FROM users WHERE email = ? AND password = ? AND status = 'INACTIVE'";

		User user = null;

		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {

				if (CommonService.StatusUpdate(email, "ACTIVE") == 1) {
					user = CommonService.Search(email);
				}
			}

		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}

		return user;
	}

	@Override
	public boolean Logout(String email) {
		String query = "SELECT * FROM users WHERE email = ? AND status = 'ACTIVE'";

		boolean value = false;

		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				if (CommonService.StatusUpdate(email, "INACTIVE") == 1) {
					value = true;
				}
			}

		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}

		return value;
	}

	@Override
	public List<User> viewAllUser() {
		String query = "SELECT * FROM users";
		List<User> allData = new ArrayList<User>();

		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setArea(resultSet.getString("area"));
				user.setCart(null);
				user.setCity(resultSet.getString("city"));
				user.setDoorno(resultSet.getString("doorno"));
				user.setEmail(resultSet.getString("email"));
				user.setGender(resultSet.getString("gender"));
				user.setId(resultSet.getInt("userid"));
				user.setName(resultSet.getString("name"));
				user.setPassword(null);
				user.setPhno(hideNumber(resultSet.getLong("phno")));
				user.setPincode(resultSet.getInt("pincode"));
				user.setProducts(null);
				user.setState(resultSet.getString("state"));
				user.setStatus(resultSet.getString("status"));
				user.setStreetno(resultSet.getString("streetno"));
				allData.add(user);
			}

		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		return allData;
	}
	
	public static long hideNumber(long phno) {
		
		String number = Long.toString(phno);
		number ="000000"+number.substring(5);
		return Long.parseLong(number);
	}

}
