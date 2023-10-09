package DessertShop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void testGetName() {
		Customer p = new Customer("Jhon");
		assertEquals(p.getName(), "Jhon");
	}

	@Test
	void testGetID() {
		Customer p = new Customer("Jhon");
		assertEquals(p.getID(), 1000);
	}

	@Test
	void testSetName() {
		Customer p = new Customer("Jhon");
		p.setName("Mario");
		assertEquals(p.getName(), "Mario");
	}

}
