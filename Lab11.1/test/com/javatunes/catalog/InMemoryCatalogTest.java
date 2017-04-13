package com.javatunes.catalog;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class InMemoryCatalogTest {

	private Collection<MusicItem> allMusicItems;
	Catalog catalog = new InMemoryCatalog();

	@Before
	public void setUp() {

		allMusicItems = catalog.getAll();
	}
	@Test
	public void testFindByID() {

		assertTrue(catalog.findById(5L).equals(
				new MusicItem(5L, "Little Earthquakes", "Tori Amos", "1992-01-18", 14.99, MusicCategory.ALTERNATIVE)));
	}
	@Test
	public void testFindByKeyword() {
		System.out.println(catalog.findByKeyword("Little").toString());
		
		assertTrue(catalog.findByKeyword("sadljkfhasdljhgf").size() == 0);
	}
	
	@Test
	public void testFindByCategory(){
		System.out.println(catalog.findByCategory(MusicCategory.ROCK).toString());
	}
}
