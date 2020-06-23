package Factory;

import Entity.Customer;
import Service.PremiumCustomer;
import Service.RegularCustomer;

public class CustomerFactory {
	
	public static Customer getCustomer(CustomerEnum customerType)
	{
		switch (customerType) {
		case REGULAR:
			return new RegularCustomer();
			
		case PREMIUM:
			
			return new PremiumCustomer();	
			
		default:
			return null;
		}
	}

}
