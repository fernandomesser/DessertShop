package DessertShop;

import java.util.ArrayList;

public class Order implements Payable {
	// ArrayList Attribute
	private ArrayList<DessertItem> order;
	private PayType payMethod;

	// Constructor
	public Order() {
		order = new ArrayList<DessertItem>();
		payMethod = PayType.CASH;
	}

	// Methods
	public ArrayList<DessertItem> getOrderList() {
		return order;
	}

	public void add(DessertItem item) {
		boolean valid = true;
		if (item instanceof Candy) {
			for (DessertItem it : this.order) {
				if (it instanceof Candy && ((Candy) it).isSameAs((Candy) item)) {
					((Candy) it).setCandyWeight(((Candy) it).getCandyWeight() + ((Candy) item).getCandyWeight());
					valid = false;
				}
			}
		} else if (item instanceof Cookie) {
			for (DessertItem it : this.order) {
				if (it instanceof Cookie && ((Cookie) it).isSameAs((Cookie) item)) {
					((Cookie) it).setCookieQty(((Cookie)it).getCookieQty() + ((Cookie)item).getCookieQty());
					valid = false;
				}
			}
		}
		if (valid) {
			order.add(item);
		}

	}

	public int itemCount() {
		return order.size();
	}

	public double orderCost() {
		double cost = 0;
		for (DessertItem item : order) {
			cost = cost + item.calculateCost();
		}
		return cost;
	}

	public double orderTax() {
		double tax = 0;
		for (DessertItem item : order) {
			tax = tax + item.calculateTax();
		}
		return tax;
	}

	public String toString() {
		String finalOutput = "";

		finalOutput += "------------------------------------Receipt------------------------------------";
		finalOutput += "\n";
		for (DessertItem item : order) {
			finalOutput += item;
		}
		finalOutput += "-------------------------------------------------------------------------------";
		finalOutput += String.format("%n%s%d%n", "Total number of items in order: ", itemCount());
		finalOutput += String.format("%-53s$%-12.2f[Tax: $%.2f]\n", "Order Subtotals:", orderCost(), orderTax());
		finalOutput += String.format("%-53s$%-8.2f\n", "Order Total:", orderCost() + orderTax());
		finalOutput += "-------------------------------------------------------------------------------";
		finalOutput += String.format("\nPaid for with %s", getPayType());
		return finalOutput;
	}

	public PayType getPayType() {
		return payMethod;

	}

	public void setPayType(PayType x) {
		payMethod = x;

	}
}
