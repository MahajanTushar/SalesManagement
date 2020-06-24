package Entity;

public abstract class Customer {
	
	private String cName;
	private String cPhoneNo;
	private double purchaseAmount;
	private Discount discount;
	private double billAmount;
		
	
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPhoneNo() {
		return cPhoneNo;
	}
	public void setcPhoneNo(String cPhoneNo) {
		this.cPhoneNo = cPhoneNo;
	}
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	
	

}
