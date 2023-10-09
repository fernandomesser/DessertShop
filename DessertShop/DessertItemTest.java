package DessertShop;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DessertItemTest {

	@Test
	void testGetName() {
		Candy p = new Candy("Lollipop", 0.2, 8);
		assertEquals(p.getName(), "Lollipop");
	}

	@Test
	void testSetName() {
		Candy p = new Candy("Lollipop ", 0.2, 8);
		p.setName("Chocolate");
		assertEquals(p.getName(), "Chocolate");
	}
	@Test
	void testGetTaxPercent() {
		Candy p = new Candy("Lollipop ", 0.2, 8);
		assertEquals(p.getTaxPercent(), 7.25/100, 0);
	}
	@Test
	void testSetTaxPercent() {
		Candy p = new Candy("Lollipop ", 0.2, 8);
		p.setTaxPercent(8/100);
		assertEquals(p.getTaxPercent(), 8/100, 0);
	}
	
	@Test
	void testGetPackaging() {
		Candy p = new Candy("Lollipop ", 0.2, 8);
		assertEquals(p.getPackaging(), "Bag");
	}
	@Test
	void testSetPackaging() {
		Candy p = new Candy("Lollipop ", 0.2, 8);
		p.setPackaging("None");
		assertEquals(p.getPackaging(), "None");
	}
	
	@Test
	void compareTo() {
		Candy d = new Candy("Strawberry cake", 18.7,56.9);
		Candy s = new Candy("Chocolate cake",78.8,55.8);
		assertEquals(-1,d.compareTo(s));
	}
	@Test
	void compareToo1() {
		Candy d = new Candy("Strawberry cake", 18.7,56.9);
		Candy s = new Candy("Chocolate cake",78.8,55.8);
		assertEquals(1,s.compareTo(d));
	}
	@Test
	void compareToo() {
		Candy d = new Candy("Strawberry cake", 18.7,56.9);
		Candy s = new Candy("Chocolate cake",56.9,18.7);
		assertEquals(0,s.compareTo(d));
	}

}
