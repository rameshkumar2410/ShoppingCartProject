package com.shoppingcart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.repository.ShoppingOrderRepositsory;
import com.shoppingcart.service.ShoppingCartService;

/**
 * 
 * @author Ramesh
 * @param <R>
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingOrderRepositsory shoppingOrderRepositsory;

	public Optional<ShoppingCart> getShoppingCartDetails(long orderId) {
		return shoppingOrderRepositsory.findById(orderId);
	}

	public List<ShoppingCart> getShoppingCartList() {
		return shoppingOrderRepositsory.findAll();
	}

	@Override
	public ShoppingCart save(ShoppingCart shoppingCart) {
		ShoppingCart shpCart = shoppingOrderRepositsory.save(shoppingCart);
		return shpCart;
	}

}
