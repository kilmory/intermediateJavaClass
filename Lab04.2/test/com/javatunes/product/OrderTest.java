package com.javatunes.product;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
  private ShoppingCart<Product> productCart;
  private ShoppingCart<MusicItem> musicCart;
  private ShoppingCart<MediaPlayer> mediaCart;
  
  @Before
  public void init() {
    productCart = new ShoppingCart<Product>();
    productCart.addItem(new MusicItem("CD-501"));
    productCart.addItem(new MediaPlayer("MP3-LP150"));
    
    musicCart = new ShoppingCart<MusicItem>();
    musicCart.addItem(new MusicItem("CD-521"));
    musicCart.addItem(new MusicItem("CD-514"));
    
    mediaCart = new ShoppingCart<MediaPlayer>();
    mediaCart.addItem(new MediaPlayer("AAC-PL233"));
  }
  
  // DONE: create new Order for each cart above and pass cart to processOrder()
  @Test
  public void testProcessCart() {
    Order order1 = new Order("order-1");
    order1.processCart(productCart);
    
    Order order2 = new Order("order-2");
    order2.processCart(musicCart);
    
    Order order3 = new Order("order-3");
    order3.processCart(mediaCart);
  }
  
  // OPTIONAL
  @SuppressWarnings("unchecked")
  @Test
  public void testProcessAllCarts() {
    Order order = new Order("order-1");
    order.processAllCarts(productCart, musicCart, mediaCart);
  }
}