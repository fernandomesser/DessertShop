package DessertShop;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.validator.PublicClassValidator;

public class Customer {
	// Atributes

	private String custName;
	private ArrayList<Order> orderHistory;
	private int custID;
	private static int nextCustID = 1000;

	public Customer(String n) {
		custName = n;
		orderHistory = new ArrayList<Order>();
		custID = nextCustID;
		nextCustID++;
	}

	public String getName() {
		return custName;
	}

	public int getID() {
		return custID;
	}

	public ArrayList<Order> getOrderHistory() {
		return orderHistory;
	}

	public void setName(String n) {
		custName = n;
	}

	public void addToHistory(Order o) {
		orderHistory.add(o);
	}

}
