package DessertShop;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CandyTest {

	@Test
	void testGetCandyWeight() {
		Candy p = new Candy("Chocolate", 1, 2.99);
		assertEquals(p.getCandyWeight(), 1, 0);
		
	}

	@Test
	void testSetCandyWeight() {
		Candy p = new Candy("Chocolate", 1, 2.99);
		p.setCandyWeight(2);
		assertEquals(p.getCandyWeight(), 2, 0);
		
	}

	@Test
	void testGetPricePerPound() {
		Candy p = new Candy("Chocolate", 1, 2.99);
		assertEquals(p.getPricePerPound(),2.99, 0);
	}

	@Test
	void testSetPricePerPound() {
		Candy p = new Candy("Chocolate", 1, 2.99);
		p.setPricePerPound(1.99);
		assertEquals(p.getPricePerPound(), 1.99, 0);
	}
	@Test
	void testCalculateCost() {
		Candy p = new Candy("Chocolate", 1, 2.99);
		assertEquals(p.calculateCost(), 2.99, 0);
	}
	@Test
	void testCalculateTax() {
		Candy p = new Candy("Chocolate", 1, 2.99);
		assertEquals(p.calculateTax(), p.getTaxPercent()*p.calculateCost(), 0);
	}
	
	@Test
	void testGetPackaging() {
		Candy p = new Candy("Chocolate", 1, 2.99);
		assertEquals(p.getPackaging(), "Bag");
	}
	@Test
	void testSetPackaging() {
		Candy p = new Candy("Chocolate", 1, 2.99);
		p.setPackaging("None");
		assertEquals(p.getPackaging(), "None");
	}
	
	@Test
	void testIsSameItem() {
		Candy p1 = new Candy("Chocolate", 1, 2.99);
		Candy p2 = new Candy("Chocolate", 3, 2.99);
		Candy p3 = new Candy("Chocolate", 1, 5.50);
		assertEquals(p1.isSameAs(p2), true);
		assertEquals(p1.isSameAs(p3), false);
		
	}

}
