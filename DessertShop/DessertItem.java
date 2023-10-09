/**
* File: DessertItem.java
* Description: Create a superclass.
* Lessons Learned: This project helped me learn how to create a new superclass.
* public DessertItem(){
*  variables
* }
*   
* Instructor's Name: Jeff Light
*
* @author     Fernando Messer, Moroni Ibirra
* @since       01/19/2023
*/
package DessertShop;

public abstract class DessertItem implements Packaging, Comparable<DessertItem> {
	
	//Attributes
	
	private String packaging;
	private String name;
	private double taxPercent = 7.25/100;
	
	//Constructors
	
	public DessertItem() {
		name = "";
	}
	
	public DessertItem(String n) {
		name = n;
	}
	
	//Methods
	
	//Getter
	public String getName() {
		return name;
	}
	
	//Setter
	public void setName(String n) {
		name = n;
	}
	
	public double getTaxPercent() {
		return taxPercent;
	}
	
	public void setTaxPercent(double p) {
		taxPercent = p;
	}
	public abstract double calculateCost(); 
	
	public double calculateTax() {
		return taxPercent * calculateCost();
	}
	
	public String getPackaging() {
		return packaging;
	}
	
	public void setPackaging(String x) {
		packaging = x;
	}
	
	public int compareTo(DessertItem other) {
		if(this.calculateCost()>other.calculateCost()) {
			return 1;
		}else if(this.calculateCost()<other.calculateCost()) {
			return -1;
		}
		return 0;
		
	}
	
}
