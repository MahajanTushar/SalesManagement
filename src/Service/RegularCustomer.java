package Service;

import java.util.LinkedHashMap;
import java.util.Map;

import Entity.Customer;
import Entity.Discount;
import discountSlab.CustomerDiscountData;

public class RegularCustomer  extends Customer implements DiscountCalculation{

	private String regularPromotions; 	
	
	public RegularCustomer(String regularPromotions) {
		super();
		this.regularPromotions = regularPromotions;
	}

	public RegularCustomer() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	public void getCalculatedDiscount() {
		
		double discountAmount = 0.0;
		double purchaseAmount = super.getPurchaseAmount();
		
		
		Map<Integer,Double> map = this.mapDiscountToCustomerType();
		int count =0;
		
		for(Map.Entry<Integer, Double> m : map.entrySet())
		{
			if(purchaseAmount > 0)
			{
				if(purchaseAmount - CustomerDiscountData.getRegularCustomerSlabdifference() >= CustomerDiscountData.getRegularCustomerSlabdifference())
				{
					discountAmount = discountAmount + CustomerDiscountData.getRegularCustomerSlabdifference() * (m.getValue()/100);
					purchaseAmount = purchaseAmount - CustomerDiscountData.getRegularCustomerSlabdifference();
				}
				else
				{
					discountAmount = discountAmount + purchaseAmount * (m.getValue()/100);
					purchaseAmount = 0;
				}
			}
			count++;
		}
		
		Discount discount = new Discount();
		discount.setDiscountValue(discountAmount);
		
		super.setDiscount(discount);
		super.setBillAmount(super.getPurchaseAmount() - discountAmount);
	}

	public String getRegularPromotions() {
		return regularPromotions;
	}

	public void setRegularPromotions(String regularPromotions) {
		this.regularPromotions = regularPromotions;
	}

	public Map<Integer, Double> mapDiscountToCustomerType()
	{
		
		Map<String, Map<Integer, Double>> map = CustomerDiscountData.getMappingOfDiscountAndSlabs();
		Map<Integer,Double> newMap = new LinkedHashMap<Integer,Double>();
		
		for(Map.Entry<String, Map<Integer,Double>> customerDiscountAndSlabMap : map.entrySet())
		{
			if(customerDiscountAndSlabMap.getKey().equals("R"))
			{
				for(Map.Entry<Integer, Double> m : customerDiscountAndSlabMap.getValue().entrySet())
				{
					if(super.getPurchaseAmount() > m.getKey())
					{
						newMap.put(m.getKey(), m.getValue());
					}
				}
			}
		}
		
		
		return newMap;
	}


}
