package com.ShoppingCart;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.shoppingcart.model.ProductDetail;
import com.shoppingcart.model.ShoppingCart;
import com.shoppingcart.repository.ShoppingOrderRepositsory;
import com.shoppingcart.service.ShoppingCartService;
/**
 * 
 * @author Ramesh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartApplicationTests {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	ShoppingCartService shoppingCartService;

	@Autowired
	ShoppingOrderRepositsory shoppingOrderRepo;

	/**
	 * To test the Message has been received, Please check the console as it reached the JMS listener and Save the data.
	 */
	@Test
	public void messageReceiverTest() {
		List<ProductDetail> details = new ArrayList<ProductDetail>();
		details.add(new ProductDetail(1, "Soap", 2, 45));
		ShoppingCart shoppingCart = new ShoppingCart(1, details);
		this.jmsTemplate.convertAndSend("shoppingCartQueue", shoppingCart);
		this.jmsTemplate.setReceiveTimeout(1_000);
		assertThat(this.jmsTemplate.receiveAndConvert("shoppingCartQueue"))
				.isEqualTo(this.jmsTemplate.receiveAndConvert("shoppingCartQueue"));
	}

	/**
	 * Test case is used to check the over all shopping cart has some data available, it will fail if we don't add any Products.
	 */
	@Test
	public void getShoppingCartTest() {
		List<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartList();
		assertTrue((shoppingCarts.isEmpty() ? false : true));
	}

	/**
	 * Test case is used to check the particular Order Id is available in database or not, This will fail if we dont have Order Id as 1.
	 */
	@Test
	public void getShoppingCartForOrderIdTest() {
		Optional<ShoppingCart> shoppingCarts = shoppingCartService.getShoppingCartDetails(1);
		assertEquals(1, shoppingCarts.get().getOrderId());
	}

}