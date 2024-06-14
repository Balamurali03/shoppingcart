package com.shoppingCartMain.Service;

import java.util.List;

import com.shoppingCartMain.Entity.ProductList;

public interface ProductService {
	
	public boolean addProduct(ProductList product);
	public List<ProductList> getProductList();
	public boolean deleteProduct(int id);

}
