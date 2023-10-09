package DessertShop;

import java.util.Objects;

public class Candy extends DessertItem implements SameItem<Candy>{

	//Attributes
	private double candyWeight;
	private double pricePerPound;

	//Constructor
	public Candy() {
		super();
		candyWeight = 0;
		pricePerPound = 0;
		setPackaging("");
		
	}
	
	public Candy(String n, double w, double p) {
		super(n);
		candyWeight = w;
		pricePerPound = p;
		setPackaging("Bag");
	}
	
	//Methods
	
	public double getCandyWeight() {
		return candyWeight;
	}
	
	public void setCandyWeight(double w) {
		candyWeight = w;
	}
	
	public double getPricePerPound() {
		return pricePerPound;
	}
	
	public void setPricePerPound(double p	) {
		pricePerPound = p;
	}
	public double calculateCost() {
		return pricePerPound * candyWeight;
	}
	
	public String toString() {
		String line1 = String.format("%s (%s)",getName(),getPackaging());
		String line2Pt1 = String.format("%-4.2flbs. @ $%.2f/lb:", candyWeight, pricePerPound);
		String line2Pt2 = String.format("$%-8.2f", calculateCost());
		String line2Pt3 = String.format("[Tax: $%.2f]\n", super.calculateTax());
		String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2Pt1, line2Pt2, line2Pt3);
		return outputVar;
	}

	@Override
	public boolean isSameAs(Candy other) {
		return Objects.equals(this.getName(), other.getName()) && (this.getPricePerPound() == other.getPricePerPound());
		
	}
	
}
