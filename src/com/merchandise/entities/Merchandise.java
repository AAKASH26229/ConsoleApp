package com.merchandise.entities;

public class Merchandise {

	int partnerId;
	String partnerName;
	String City;
	String StateProperties;
	
	public String Validate() {
		
		if(partnerId>0 && partnerId!=0) {
			return "Partner Id is Mandatory and Non-Negative";
		}
		
		return "error";
	}

}
