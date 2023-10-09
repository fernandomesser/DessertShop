package DessertShop;

public class Sundae extends IceCream{
	//Attributes
	private String toppingName;
	private double toppingPrice;

	//Constructor
	public Sundae() {
		super();
		toppingName = "";
		toppingPrice = 0;
		setPackaging("");
	}
	
	public Sundae(String n, int s, double p, String tn, double tp) {
		super(n, s, p);
		toppingName = tn;
		toppingPrice = tp;
		setPackaging("Boat");
	}
	
	//Methods
	
	public String getToppingName() {
		return toppingName;
	}
	
	public void setToppingName(String tn) {
		toppingName = tn;
	}
	
	public double getToppingPrice() {
		return toppingPrice;
	}
	
	public void setToppingPrice(double tp) {
		toppingPrice = tp;
	}
	
	public double calculateCost() {
		return getScoopCount() * getPricePerScoop() + toppingPrice;
	}
	
	public String toString() {
		String line1 = String.format("%s (%s)",getName(),super.getPackaging());
		String line2Pt1 = String.format("%.2f scoops of %s ice cream @ $%.2f/scoop\n\t%s topping @ $%.2f:", getScoopCount(), getName(), getPricePerScoop(), toppingName, toppingPrice);
		String line2Pt2 = String.format("%24s%.2f", "$", calculateCost());
		String line2Pt3 = String.format("[Tax: $%.2f]\n", getTaxPercent());
		String outputVar = String.format("%s\n\t%-45s%s%17s", line1, line2Pt1, line2Pt2, line2Pt3);
		return outputVar;
	}


}
