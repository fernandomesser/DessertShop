package DessertShop;

public interface Payable {
	
	enum PayType {
		CASH, 
		CARD, 
		PHONE
	}
	
	public abstract PayType getPayType();
	public abstract void setPayType(PayType x);
	

}
