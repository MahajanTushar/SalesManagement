package com;

import Entity.Customer;
import Factory.CustomerEnum;
import Factory.CustomerFactory;
import Service.PremiumCustomer;
import Service.RegularCustomer;

public class MainClass {

	public static void main(String[] args) {
		
		
		Customer c1 = CustomerFactory.getCustomer(CustomerEnum.REGULAR);
		
		c1.setcName("Tushar");
		c1.setcPhoneNo("23232");
		c1.setPurchaseAmount(10000.00);
		
		if(c1 instanceof RegularCustomer)
		{
			((RegularCustomer) c1).getCalculatedDiscount();
		}
		
		System.out.println(c1.getDiscount().getDiscountValue() + " is the discount for regular customer for purchase of " +  c1.getPurchaseAmount() + " rupees and " + c1.getBillAmount() + " is the bill amount");
		
		Customer c2 = CustomerFactory.getCustomer(CustomerEnum.PREMIUM);
		c2.setPurchaseAmount(8000.0);
		
		if(c2 instanceof PremiumCustomer)
		{
			((PremiumCustomer) c2).getCalculatedDiscount();
		}
		
		System.out.println(c2.getDiscount().getDiscountValue() + " is the discount for regular customer for purchase of " +  c2.getPurchaseAmount() + " rupees and " + c2.getBillAmount() + " is the bill amount");
		
		
	}
}
