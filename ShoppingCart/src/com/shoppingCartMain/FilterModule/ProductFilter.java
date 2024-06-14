package com.shoppingCartMain.FilterModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shoppingCartMain.DataBase.DatabaseConnection;

public class ProductFilter {
	
	public List<String> filterOnCategory(String category){
		String query = "SELECT producttype FROM product WHERE category = ? ";
		List<String> allCategory = new ArrayList<>();
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
    public List<String> filterOnProductType(String productType){
    	String query = "SELECT brand FROM product WHERE producttype = ? ";
		List<String> allproductType = new ArrayList<>();
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
				allBrand.add("productid : "+resultSet.getInt("productid")+" => name : "+resultSet.getString("name"));
			}
			
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return allBrand;
}
    public List<String> filterAllCategory(){
		String query = "SELECT category FROM product";
		List<String> allTypeCategory = new ArrayList<>();
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
