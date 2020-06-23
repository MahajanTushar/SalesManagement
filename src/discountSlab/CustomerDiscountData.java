package discountSlab;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum CustomerDiscountData {
	
	SlabL1("R",0,0.0),SlabL2("R",5000,10.0),SlabL3("R",10000,20.0),
	SlabL4("P",0,10.0),SlabL5("P",4000,15.0),Slab6("P",8000,20.0),Slab7("P",12000,30.0);
	
	private  Double discountPercentage;
	private Integer slabLowerRange;
	private  String customerType;
	
	private final static Integer regularCustomerSlabDifference = 5000;
	private final static Integer premiumCustomerSlabDifference = 4000;
	
	private final static Map<String, Map<Integer, Double>> slabAndDiscountMapping = Collections.unmodifiableMap(setMappingOfDiscountAndSlabs());



	CustomerDiscountData(String customerType, Integer slabLowerRange, double discountPercentage) {

		this.discountPercentage = discountPercentage;
		this.slabLowerRange = slabLowerRange;
		this.customerType = customerType;
		
	}
	
	CustomerDiscountData(Integer slabLowerRange)
	{
		this.slabLowerRange = slabLowerRange;
	}
	

	private static  Map<String, Map<Integer,Double>> setMappingOfDiscountAndSlabs() {
		
		
		 Map<Integer, Double> slabToRangeMapper = new LinkedHashMap<Integer, Double>();
		 
		 Map<String, Map<Integer,Double>> customerAndSlabDiscountMap = new HashMap<>();
		
		 String currentCustomerType = null;
		 
			 for(CustomerDiscountData d : CustomerDiscountData.values())
			 {
				 if(currentCustomerType == null)
				 {
					 currentCustomerType = d.getCustomerType();
				 }
				 else if(!currentCustomerType.equals(d.getCustomerType()))
				 {
					 customerAndSlabDiscountMap.put(currentCustomerType, slabToRangeMapper);
					 currentCustomerType = d.getCustomerType();
					 slabToRangeMapper = new LinkedHashMap<Integer,Double>();
				 }
				 
					 slabToRangeMapper.put(d.slabLowerRange, d.discountPercentage);
				 
				 	 
			 } 
			 
			 if(customerAndSlabDiscountMap.isEmpty() ||  !slabToRangeMapper.isEmpty())
			 {
				 customerAndSlabDiscountMap.put(currentCustomerType,slabToRangeMapper);
			 }
			 
		 return  customerAndSlabDiscountMap;
	}
	
	
	public static Integer getRegularCustomerSlabdifference()
	{
		return regularCustomerSlabDifference;
	}

	public static Integer getPremiumCustomerSlabDifference()
	{
		return premiumCustomerSlabDifference;
	}
	
	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Integer getSlabLowerRange() {
		return slabLowerRange;
	}

	public void setSlabLowerRange(Integer slabLowerRange) {
		this.slabLowerRange = slabLowerRange;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	
	public static Map<String, Map<Integer,Double>> getMappingOfDiscountAndSlabs()
	{
		if(slabAndDiscountMapping == null)
		{
			setMappingOfDiscountAndSlabs();
		}
		return slabAndDiscountMapping;
	}

}
