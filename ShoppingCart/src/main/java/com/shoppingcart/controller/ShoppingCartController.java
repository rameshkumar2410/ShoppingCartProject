package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.model.ShoppingCart;
/**
 * 
 * @author Ramesh
 *
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping(value = "/sendShoppingProduct")
	public void sendShoppingProduct(@RequestBody ShoppingCart shoppingCart) {
		jmsTemplate.convertAndSend("shoppingCartQueue", shoppingCart);
	}

}
