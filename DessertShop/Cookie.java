package DessertShop;

import java.util.Objects;

public class Cookie extends DessertItem implements SameItem<Cookie> {
	// Attributes
	private int cookieQty;
	private double pricePerDozen;

	// Constructor
	public Cookie() {
		super();
		cookieQty = 0;
		pricePerDozen = 0;
		setPackaging("");
	}

	public Cookie(String n, int c, double p) {
		super(n);
		cookieQty = c;
		pricePerDozen = p;
		setPackaging("Box");
	}

	// Methods

	public int getCookieQty() {
		return cookieQty;
	}

	public void setCookieQty(int c) {
		cookieQty = c;
	}

	public double getPricePerDozen() {
		return pricePerDozen;
	}

	public void setPricePerDozen(double p) {
		pricePerDozen = p;
	}

	public double calculateCost() {
		return pricePerDozen * cookieQty / 12;
	}

	public String toString() {
		String line1 = String.format("%s (%s)", getName(), getPackaging());
		String line2Pt1 = String.format("%d cookies @ $%.2f/dozen:", cookieQty, pricePerDozen);
		String line2Pt2 = String.format("$%-8.2f", calculateCost());
		String line2Pt3 = String.format("[Tax: $%.2f]\n", super.calculateTax());
		String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2Pt1, line2Pt2, line2Pt3);
		return outputVar;
	}

	@Override
	public boolean isSameAs(Cookie other) {
		return Objects.equals(this.getName(), other.getName()) && (this.getPricePerDozen() == other.getPricePerDozen());
	}
}
