package com.shoppingCartMain.FilterModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.shoppingCartMain.DataBase.DatabaseConnection;

public class ProductFilter {
	
	public Set<String> filterOnCategory(String category){
		String query = "SELECT producttype FROM product WHERE category = ? ";
		Set<String> allCategory = new HashSet<>();
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, category);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				allCategory.add(resultSet.getString("producttype"));
			}
			
			
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return allCategory;
	}
    public Set<String> filterOnProductType(String productType){
    	String query = "SELECT brand FROM product WHERE producttype = ? ";
		Set<String> allproductType = new HashSet<>();
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, productType);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				allproductType.add(resultSet.getString("brand"));
			}
			
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return allproductType;
	}
    public List<String> filterOnBrand(String brand){
    	String query = "SELECT * FROM product WHERE brand = ? ";
		List<String> allBrand = new ArrayList<>();
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, brand);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				allBrand.add("productid : "+resultSet.getInt("productid")+" => name : "+resultSet.getString("name")
				+" => price : "+resultSet.getDouble("price"));
			}
			
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return allBrand;
}
    public Set<String> filterAllCategory(){
		String query = "SELECT category FROM product";
		Set<String> allTypeCategory = new HashSet<>();
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				allTypeCategory.add(resultSet.getString("category"));
			}
			
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return allTypeCategory;
	}
    

}
