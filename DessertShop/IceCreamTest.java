package DessertShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IceCreamTest {

	@Test
	void testGetScoopCount() {
		IceCream p = new IceCream("Vanilla", 2, 1.50);
		assertEquals(p.getScoopCount(), 2);
	}

	@Test
	void testSetScoopCount() {
		IceCream p = new IceCream("Vanilla", 2, 1.50);
		p.setScoopCount(1);
		assertEquals(p.getScoopCount(), 1);
	}

	@Test
	void testGetPricePerScoop() {
		IceCream p = new IceCream("Vanilla", 2, 1.50);
		assertEquals(p.getPricePerScoop(), 1.50);
	}

	@Test
	void testSetPricePerScoop() {
		IceCream p = new IceCream("Vanilla", 2, 1.50);
		p.setPricePerScoop(1.60);
		assertEquals(p.getPricePerScoop(), 1.60);
	}
	@Test
	void testCalculateCost() {
		IceCream p = new IceCream("Vanilla", 2, 1.50);
		assertEquals(p.calculateCost(), 3);
	}
	@Test
	void testCalculateTax() {
		IceCream p = new IceCream("Vanilla", 2, 1.50);
		assertEquals(p.calculateTax(), p.getTaxPercent()*p.calculateCost());
	}
	
	@Test
	void testGetPackaging() {
		IceCream p = new IceCream("Vanilla", 2, 1.50);
		assertEquals(p.getPackaging(), "Bowl");
	}
	@Test
	void testSetPackaging() {
		IceCream p = new IceCream("Vanilla", 2, 1.50);
		p.setPackaging("None");
		assertEquals(p.getPackaging(), "None");
	}

}
