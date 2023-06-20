package com.merchandise.entities;

public class Merchandise {

	//class “Merchandise” with partnerId, partnerName, City, State properties
	
	int partnerId;
	String partnerName;
	String City;
	String StateProperties;
	
	public String Validate() {
		
		if( partnerId > 0 && partnerId != 0 ) {
			
			return "Partner Id is Mandatory and Non-Negative";
		}
		else if( partnerName != null && partnerName.length() >= 5 ) {
			
			return "Partner Name is mandatory and have minimum 5 characters";
		}
		else if( City != null && City.length() >= 3 ) {
			
			return "City is mandatory and have minimum 3 characters";
		}
		else if( StateProperties != null && StateProperties.length() >= 3) {
			
			return "State is mandatory and have minimum 3 characters";
		}
		return "Enter details carefully";
		
	}

}
