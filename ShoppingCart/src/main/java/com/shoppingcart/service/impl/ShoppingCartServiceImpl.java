package com.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.repository.ShoppingOrderRepositsory;
import com.shoppingcart.service.ShoppingCartService;
/**
 * 
 * @author Ramesh
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingOrderRepositsory shoppingOrderRepositsory;

	public ShoppingCart getShoppingCartDetails(int orderId) {
		return shoppingOrderRepositsory.getOne(orderId);
	}

	public List<ShoppingCart> getShoppingCartList(int orderId) {
		return shoppingOrderRepositsory.findAll();
	}

	@Override
	public ShoppingCart save(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return null;
	}

}
