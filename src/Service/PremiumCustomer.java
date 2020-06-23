package Service;

import java.util.LinkedHashMap;
import java.util.Map;

import Entity.Customer;
import Entity.Discount;
import discountSlab.CustomerDiscountData;

public class PremiumCustomer extends Customer {

	private boolean earlySaleAccess;
	
	public PremiumCustomer() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public PremiumCustomer(boolean earlySaleAccess) {
		// TODO Auto-generated constructor stub
		super();
		this.earlySaleAccess = earlySaleAccess;
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
				if(purchaseAmount - CustomerDiscountData.getPremiumCustomerSlabDifference() >= CustomerDiscountData.getPremiumCustomerSlabDifference() && map.size()-count > 1)
				{
					discountAmount = discountAmount + CustomerDiscountData.getPremiumCustomerSlabDifference() * (m.getValue()/100);
					purchaseAmount = purchaseAmount - CustomerDiscountData.getPremiumCustomerSlabDifference();
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

	public Map<Integer, Double> mapDiscountToCustomerType()
	{
	
		Map<String, Map<Integer, Double>> map = CustomerDiscountData.getMappingOfDiscountAndSlabs();
		Map<Integer,Double> newMap = new LinkedHashMap<Integer,Double>();
		
		for(Map.Entry<String, Map<Integer,Double>> customerDiscountAndSlabMap : map.entrySet())
		{
			if(customerDiscountAndSlabMap.getKey().equals("P"))
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
