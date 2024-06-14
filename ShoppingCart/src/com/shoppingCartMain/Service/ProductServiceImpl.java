package com.shoppingCartMain.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingCartMain.DataBase.DatabaseConnection;
import com.shoppingCartMain.Entity.ProductList;

public class ProductServiceImpl implements ProductService{

	@Override
	public boolean addProduct(ProductList product) {
		
		String query = "INSERT INTO product (category, producttype, name, brand, gender,"
				+ " agegroup, color, price, userid)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				boolean value = false;
				
				try (Connection connection = DatabaseConnection.getConnection()) {
					PreparedStatement statement = connection.prepareStatement(query);

					if(CommonService.checkUser(product.getUser())) {
					
						statement.setString(1, product.getCategory());
						statement.setString(2, product.getProducttype());
						statement.setString(3, product.getName());
						statement.setString(4, product.getBrand());
						statement.setString(5, product.getGender());
						statement.setString(6, product.getAgegroup());
						statement.setString(7, product.getColor());
						statement.setDouble(8, product.getPrice());
						statement.setInt(9, product.getUser());
						
						int reg = statement.executeUpdate();
						if (reg == 1) {
							value = true;
						}
					}
					

				} catch (SQLException e) {

					System.out.println("SQLException: " + e.getMessage());
				}

				
		return value;
	}

	@Override
	public List<ProductList> getProductList() {
		
		String query = "SELECT * FROM product";
		List<ProductList> allProduct = new ArrayList<>();
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				ProductList product = new ProductList();
				product.setId(resultSet.getInt("productid"));
				product.setName(resultSet.getString("name"));
				product.setCategory(resultSet.getString("category"));
				product.setProducttype(resultSet.getString("producttype"));
				product.setBrand(resultSet.getString("brand"));
				product.setGender(resultSet.getString("gender"));
				product.setAgegroup(resultSet.getString("agegroup"));
				product.setColor(resultSet.getString("color"));
				product.setPrice(resultSet.getDouble("price"));
				product.setUser(resultSet.getInt("userid"));
				
				allProduct.add(product);
			}
			
			
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return allProduct;
	}

	@Override
	public boolean deleteProduct(int id) {
		String query ="DELETE FROM product WHERE productid = ?";
		boolean value = false;
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			
			if(CommonService.checkStatus(id)) {
				
				statement.setInt(1, id);
				if(statement.execute()) {
					value = true;
				}
			}
		
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return value;
	}

}
