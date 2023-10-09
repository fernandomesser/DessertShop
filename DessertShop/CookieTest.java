package DessertShop;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CookieTest {

	@Test
	void testGetCookieQty() {
		Cookie p = new Cookie("Oreo", 12, 1.99);
		assertEquals(p.getCookieQty(), 12);
	}

	@Test
	void testSetCookieQty() {
		Cookie p = new Cookie("Oreo", 12, 1.99);
		p.setCookieQty(15);
		assertEquals(p.getCookieQty(), 15);
	}

	@Test
	void testGetPricePerDozen() {
		Cookie p = new Cookie("Oreo", 12, 1.99);
		assertEquals(p.getPricePerDozen(), 1.99, 0);
	}

	@Test
	void testSetPricePerDozen() {
		Cookie p = new Cookie("Oreo", 12, 1.99);
		p.setPricePerDozen(2.01);
		assertEquals(p.getPricePerDozen(), 2.01, 0);
	}
	@Test
	void testCalculateCost() {
		Cookie p = new Cookie("Oreo", 12, 1.99);
		assertEquals(p.calculateCost(), 1.99, 0);
	}
	@Test
	void testCalculateTax() {
		Cookie p = new Cookie("Oreo", 12, 1.99);
		assertEquals(p.calculateTax(), p.getTaxPercent()*p.calculateCost(), 0);
	}
	
	@Test
	void testGetPackaging() {
		Cookie p = new Cookie("Oreo", 12, 1.99);
		assertEquals(p.getPackaging(), "Box");
	}
	@Test
	void testSetPackaging() {
		Cookie p = new Cookie("Oreo", 12, 1.99);
		p.setPackaging("None");
		assertEquals(p.getPackaging(), "None");
	}
	
	@Test
	void testIsSameItem() {
		Cookie p1 = new Cookie("Oreo", 12, 1.99);
		Cookie p2 = new Cookie("Oreo", 24, 1.99);
		Cookie p3 = new Cookie("Oreo", 12, 2.99);
		assertEquals(p1.isSameAs(p2), true);
		assertEquals(p1.isSameAs(p3), false);
		
	}

}
