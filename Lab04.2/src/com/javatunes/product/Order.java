/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.Collection;

public class Order {
	private String id;

	public Order(String id) {
		this.id = id;
	}

	/**
   * TODO:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {
	  System.out.println("Order: " + getId() + " contains the following:");
	  Collection<? extends Product> cartItems = cart.allItems();
	  
	  for (Product p : cartItems) {
		  System.out.println(p.getCode());
		  
	  }
	  System.out.println("Order Total: " + cart.total());
	  
  }

	public void processAllCarts(ShoppingCart<? extends Product>... carts) {

		double orderTotal = 0.0;
		System.out.println("Order: " + getId() + " contains the following:");
		// iterate over varargs of cart(s) - carts numbered for display (too
		// fancy?)
		int cartNumber = 1;
		for (ShoppingCart<? extends Product> cart : carts) {
			System.out.println("Shopping Cart " + cartNumber + ":");
			// get the items from the cart and iterate over them, print each
			// item's product code
			// get cart total and print
			// add cart total to order total
			Collection<? extends Product> cartItems = cart.allItems();
			for (Product product : cartItems) {
				System.out.println(product.getCode());
			}
			double cartTotal = cart.total();
			System.out.println("Cart total: " + cartTotal);
			orderTotal += cartTotal;
			cartNumber++;
		}
		System.out.println("ORDER TOTAL: " + orderTotal);
	}

	public String getId() {
		return id;
	}
}