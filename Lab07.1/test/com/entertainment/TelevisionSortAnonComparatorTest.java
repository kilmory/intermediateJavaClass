package com.entertainment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.entertainment.catalog.Catalog;

public class TelevisionSortAnonComparatorTest {

	@Test
	public void testAnonComp() {
		Collection<Television> tvCollection = Catalog.getInventory();

		List<Television> tvList = new ArrayList<>(tvCollection);
		
		Collections.sort(tvList, new Comparator<Television>() {

			@Override
			public int compare(Television o1, Television o2) {
				
				return Integer.compare(o1.getVolume(), o2.getVolume());
			}
			
		});
		
		System.out.println(tvList.toString());
	}
}
