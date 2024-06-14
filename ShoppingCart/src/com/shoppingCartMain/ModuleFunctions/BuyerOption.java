package com.shoppingCartMain.ModuleFunctions;

import com.shoppingCartMain.Entity.Cart;
import com.shoppingCartMain.Service.CartService;
import com.shoppingCartMain.Service.CartServiceImpl;

public class BuyerOption {
	
	CartService service= new CartServiceImpl();
	public String fromAllProduct(String id,int uid) {
		String arr[]= id.split(",");
		int count = arr.length;
		for(int i =0;i<arr.length;i++) {
			int pid=Integer.parseInt(arr[i]);
			Cart cart= new Cart();
			cart.setUserid(uid);
			cart.setProductid(pid);
			if(service.addCart(cart)) {
				count--;
			}
		}
		if(count==0) {
			return "All products added to the cart";
		} else {
			return "products are not added properly";
		}
	}

}
