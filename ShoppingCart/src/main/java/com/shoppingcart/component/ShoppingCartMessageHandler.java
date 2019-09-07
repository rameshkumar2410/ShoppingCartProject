package com.shoppingcart.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.repository.ShoppingOrderRepositsory;
/**
 * 
 * @author Ramesh
 *
 */
@Component
public class ShoppingCartMessageHandler {

	@Autowired
	private ShoppingOrderRepositsory orderRepositsory;

	@JmsListener(destination = "shoppingCartQueue", containerFactory = "myFactory")
	public void receiveShoppingCart(ShoppingCart shoppingCart) {
		System.out.println("Received Shooping Order Message");
		orderRepositsory.save(shoppingCart);
		System.out.println("Saved Shooping Order Message");
	}

}
