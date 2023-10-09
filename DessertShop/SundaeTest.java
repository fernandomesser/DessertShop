package DessertShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SundaeTest {

	@Test
	void testGetToppingName() {
		Sundae p = new Sundae("Vanilla", 2, 1.50, "Nutella", 0.15);
		assertEquals(p.getToppingName(), "Nutella");
	}

	@Test
	void testSetToppingName() {
		Sundae p = new Sundae("Vanilla", 2, 1.50, "Nutella", 0.15);
		p.setToppingName("Marshmallows");
		assertEquals(p.getToppingName(), "Marshmallows");
	}

	@Test
	void testGetToppingPrice() {
		Sundae p = new Sundae("Vanilla", 2, 1.50, "Nutella", 0.15);
		assertEquals(p.getToppingPrice(), 0.15);
	}

	@Test
	void testSetToppingPrice() {
		Sundae p = new Sundae("Vanilla", 2, 1.50, "Nutella", 0.15);
		p.setToppingPrice(0.20);
		assertEquals(p.getToppingPrice(), 0.20);
	}
	@Test
	void testCalculateCost() {
		Sundae p = new Sundae("Vanilla", 2, 1.50, "Nutella", 0.15);
		assertEquals(p.calculateCost(), 3.15);
	}
	@Test
	void testCalculateTax() {
		Sundae p = new Sundae("Vanilla", 2, 1.50, "Nutella", 0.15);
		assertEquals(p.calculateTax(), p.getTaxPercent()*p.calculateCost());
	}
	
	@Test
	void testGetPackaging() {
		Sundae p = new Sundae("Vanilla", 2, 1.50, "Nutella", 0.15);
		assertEquals(p.getPackaging(), "Boat");
	}
	@Test
	void testSetPackaging() {
		Sundae p = new Sundae("Vanilla", 2, 1.50, "Nutella", 0.15);
		p.setPackaging("None");
		assertEquals(p.getPackaging(), "None");
	}

}
