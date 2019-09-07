package com.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.service.ShoppingCartService;
/**
 * 
 * @author Ramesh
 *
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping(value = "/sendShoppingProduct")
	public void sendShoppingProduct(@RequestBody ShoppingCart shoppingCart) {
		jmsTemplate.convertAndSend("shoppingCartQueue", shoppingCart);
	}
	
	
	/**
	 * 
	 * @param orderId
	 * @return Shopping Cart base on the Order ID
	 */
	@GetMapping(value="/getShoppingDetails/{orderId}",  produces = "application/json")
	public ResponseEntity<Optional<ShoppingCart>> getShoppingCartForOrder(@PathVariable long orderId) {
		Optional<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCartDetails(orderId);
		if(!shoppingCart.isPresent()) {
			return new ResponseEntity<Optional<ShoppingCart>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Optional<ShoppingCart>>(shoppingCart,HttpStatus.OK);
		}
	}
	
	/**
	 * 
	 * @return Shopping Cart Complete History
	 */
	@GetMapping(value="/getShoppingCartList", produces = "application/json")
	public ResponseEntity<List<ShoppingCart>> getShoppingCartList() {
		List<ShoppingCart> shoppingCart = shoppingCartService.getShoppingCartList();
		if(shoppingCart.isEmpty()) {
			return new ResponseEntity<List<ShoppingCart>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<ShoppingCart>>(shoppingCart,HttpStatus.OK);
		}
	}
	

}
