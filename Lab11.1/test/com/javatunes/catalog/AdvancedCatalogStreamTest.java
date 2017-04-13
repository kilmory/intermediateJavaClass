/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

// TODO: Uncomment the static imports that we supply as you need them
import static java.util.Comparator.comparing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class AdvancedCatalogStreamTest {
  
  private Collection<MusicItem> allMusicItems;

  @Before
  public void setUp() {
    Catalog catalog = new InMemoryCatalog();
    allMusicItems = catalog.getAll();
  }
  
  /**
   * TASK: determine average price of our low-cost, extensive catalog of music.
   * 
   * RESULT: 15.309 (via calculator)
   */
  @Test
  public void testAveragePrice() {
    OptionalDouble avgPriceOptional = allMusicItems.stream()
      .mapToDouble(MusicItem::getPrice)  // item -> item.getPrice()
      .average();
    double avgPrice = avgPriceOptional.getAsDouble();
    
    assertEquals(15.309, avgPrice, .001);
  }
  
  /**
   * TASK: determine the titles of all "pop" items, sorted by natural order.
   * 
   * RESULT: 
   */
  @Test
  public void testTitlesPopSortNaturalOrder() {
    
	  List<String> titles = allMusicItems.stream()
	  .filter(item -> item.getMusicCategory().equals(MusicCategory.POP))
	  .map(MusicItem::getTitle)
	  .sorted()
	  .collect(Collectors.toList());
	  
	  System.out.println(titles);
	 
	  
	
	  
  }
  
  /**
   * TASK: are all items priced at least $10?
   * 
   * RESULT: 
   */
  @Test
  public void testAllPriceGreaterThanEqual() {
	  List<MusicItem> items = allMusicItems.stream()
	  .filter(item -> item.getPrice() >= 10.00)
	  .collect(Collectors.toList());
	  
	  System.out.println(items.toString());
  }
  
  /**
   * TASK: do we sell any "jazz" items?
   * 
   * RESULT: 
   */
  @Test
  public void testAnyMusicCategory() {
    
	  boolean result = allMusicItems.stream()
	  .anyMatch(item -> item.getMusicCategory().equals(MusicCategory.JAZZ));
	  
	  assertFalse(result);
  }
  
  /**
   * TASK: how many "blues" items do we sell?
   * 
   * RESULT: 
   */
  @Test
  public void testCountMusicCategory() {
    long result = allMusicItems.stream()
    		.filter(item -> item.getMusicCategory().equals(MusicCategory.BLUES))
    		.count();
    
    assertEquals(2,result);
  }
  
  /**
   * TASK: print to stdout any 3 "rock" items.
   * 
   * RESULT: 
   */
  @Test
  public void testPrintAny3MusicCategory() {
    allMusicItems.stream()
    .filter(item -> item.getMusicCategory().equals(MusicCategory.ROCK))
    .limit(3)
    .forEach(item -> System.out.println(item));
    
  }
  
  /**
   * TASK: determine the average price of the 3 most recent items we sell.
   * 
   * RESULT: 
   */
  @Test
  public void testAvgPrice3Newest() {
    OptionalDouble result = allMusicItems.stream()
    		.sorted(comparing(MusicItem::getReleaseDate).reversed())
    		.limit(3)
    		.mapToDouble(m -> m.getPrice())
    		.average();
    System.out.println(result);		
  }
  
  /**
   * TASK: determine the 2 highest-priced MusicItems, sorted by title.
   * HINT: you will need to sort twice in the pipeline.
   * 
   * RESULT: 
   */
  @Test
  public void testPrice2HighestSortTitle() {
	    List<MusicItem> items = allMusicItems.stream()
	    	      .sorted(comparing(MusicItem::getPrice).reversed().thenComparing(MusicItem::getTitle))
	    	      .limit(2)
	    	      .collect(Collectors.toList());
	    
	    System.out.println(items);
  }
  
  /**
   * TASK: what is the price of our cheapest "pop" item?
   * 
   * RESULT: 
   */
  @Test
  public void testMinPriceMusicCategory() {
    OptionalDouble price = allMusicItems.stream()
    		.filter(item -> item.getMusicCategory().equals(MusicCategory.POP))
    		.sorted(comparing(MusicItem::getPrice))
    		.mapToDouble(m -> m.getPrice())
    		.min();
    
    System.out.println(price);
    		
  }
}