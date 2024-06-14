package com.shoppingCartMain.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.shoppingCartMain.DataBase.DatabaseConnection;
import com.shoppingCartMain.Entity.ProductList;
import com.shoppingCartMain.Entity.User;

public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public String generateInvoice(int id) {
		
		return invoiceTemplate(getUser(id),productIdFromCart(id));
	}
	 public static ProductList getProductObject(int id) {
		 String query = "SELECT * FROM product WHERE productid = ?";
		 ProductList product= new ProductList();
		 
		 try(Connection connection = DatabaseConnection.getConnection()){
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()) {
					product.setId(id);
					product.setName(resultSet.getString("name"));
					product.setBrand(resultSet.getString("brand"));
					product.setPrice(resultSet.getDouble("price"));
					
				}
		 } catch (SQLException e) {

				System.out.println("SQLException: " + e.getMessage());
			}
		 return product;
	 }

	public static List<ProductList> productIdFromCart(int id) {
		String query = "SELECT productid FROM cart WHERE userid = ?";
		//List<Integer> listOfProductId = new ArrayList<>();
		List<ProductList> listOfProducts = new ArrayList<>();
		
		try(Connection connection = DatabaseConnection.getConnection()){
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				listOfProducts.add(getProductObject(resultSet.getInt("productid")));
				//listOfProductId.add(resultSet.getInt("productid"));
			}
//			for(int productid : listOfProductId) {
//				listOfProducts.add(getProductObject(productid));
//			}
			
		} catch (SQLException e) {

			System.out.println("SQLException: " + e.getMessage());
		}
		
		return listOfProducts;
	}
	
	public static User getUser(int id) {
		String query = "SELECT * FROM users WHERE userid = ?";
		User user =null;
		
		try (Connection connection = DatabaseConnection.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				 String email = resultSet.getString("email");
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
	public static String invoiceTemplate(User user, List<ProductList> listOfProducts) {
		
		List<ProductList> plist = listOfProducts.stream().sorted(Comparator.comparing(ProductList::getId))
                .collect(Collectors.toList());
		double total=0;
		int nos=1;
		for(int i= 0; i<plist.size();i++) {
			total = total +plist.get(i).getPrice();
		}
		String template="Hello "+user.getName()+"\n This invoice is regarding your cart history and the price.The"
				+ "total amount estimated was "+total+" the details are below \n "
						+ "\n SNO		ProductName		ProductBrand		Quantity		ProductPrice \n";
		
		int count=plist.get(0).getId();
		int quantity=0;
		double amount=0;
		for(int i= 0; i<plist.size();i++) {
			if(count==plist.get(i).getId()) {
				quantity++;
				amount=amount+plist.get(i).getPrice();
			} else {
				template = template+ "\n "+ nos+"		"+		plist.get(i-1).getName()+"			"+		plist.get(i-1).getBrand()+"			"+		quantity+"			"+		amount+ "\n";
				nos++;
				count =plist.get(i).getId();
				quantity=1;
				amount= plist.get(i).getPrice();
			}
			
		}
		template = template+ "\n "+ nos+"		"+		plist.get(plist.size()-1).getName()+"			"+		plist.get(plist.size()-1).getBrand()+"			"+		quantity+"			"+		amount+ "\n"
				+ "\n \n The Grand Total is :						"+total;
		
		return template;
	}
}
