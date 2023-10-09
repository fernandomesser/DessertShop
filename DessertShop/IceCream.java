package DessertShop;

public class IceCream extends DessertItem{
	//Attributes
		private int scoopCount;
		private double pricePerScoop;

		//Constructor
		public IceCream() {
			super();
			scoopCount = 0;
			pricePerScoop = 0;
			setPackaging("");
		}
			
		public IceCream(String n, int s, double p) {
			super(n);
			scoopCount = s;
			pricePerScoop = p;
			setPackaging("Bowl");
		}
			
		//Methods
			
		public double getScoopCount() {
			return scoopCount;
		}
			
		public void setScoopCount(int s) {
			scoopCount = s;
		}
			
		public double getPricePerScoop() {
			return pricePerScoop;
		}
			
		public void setPricePerScoop(double s) {
			pricePerScoop = s;
		}
		
		public double calculateCost() {
			return pricePerScoop * scoopCount;
		}

		public String toString() {
			String line1 = String.format("%s (%s)",getName(),getPackaging());
			String line2Pt1 = String.format("%d scoops  @ $%.2f/scoop:", scoopCount, pricePerScoop);
			String line2Pt2 = String.format("$%-8.2f", calculateCost());
			String line2Pt3 = String.format("[Tax: $%.2f]\n", super.calculateTax());
			String outputVar =String.format("%s\n\t%-45s%s%17s", line1, line2Pt1, line2Pt2, line2Pt3);
			return outputVar;
		}
		
}
