package com.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.shoppingcart.model.ShoppingCart;

/**
 * 
 * @author Ramesh
 *
 */
public interface ShoppingCartService {
	ShoppingCart save(ShoppingCart shoppingCart);
	
	Optional<ShoppingCart> getShoppingCartDetails(long orderId);	
	
	List<ShoppingCart> getShoppingCartList();
	
}
