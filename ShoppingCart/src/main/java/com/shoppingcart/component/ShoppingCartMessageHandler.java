package com.shoppingcart.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.service.ShoppingCartService;
/**
 * 
 * @author Ramesh
 *
 */
@Component
public class ShoppingCartMessageHandler {
	
	@Autowired
	ShoppingCartService shoppingCartService;

	@JmsListener(destination = "shoppingCartQueue", containerFactory = "myFactory")
	public void receiveShoppingCart(ShoppingCart shoppingCart) {
		System.out.println("Received Shopping Order Details"+shoppingCart.getOrderId());
		ShoppingCart shoppingCarts=shoppingCartService.save(shoppingCart);
		System.out.println("Saved Shopping Order Details"+shoppingCarts.getOrderId());
	}

}
