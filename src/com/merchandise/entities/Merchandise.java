package com.merchandise.entities;

import java.util.ArrayList;
import java.util.List;

public class Merchandise {

	//class “Merchandise” with partnerId, partnerName, City, State properties
	
	protected int partnerId;
	protected String partnerName;
	protected String City;
	protected String StateProperties;
	
	
	
	public Merchandise() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Merchandise(int partnerId, String partnerName, String city, String stateProperties) {
		super();
		this.partnerId = partnerId;
		this.partnerName = partnerName;
		City = city;
		StateProperties = stateProperties;
	}


	public String[] Validate() {
		List<String> errors = new ArrayList<>();
		
		if( partnerId > 0 && partnerId != 0 ) {
			
			errors.add("Partner Id is mandatory and must be a positive number");
		}
		else if( partnerName != null && partnerName.length() >= 5 ) {
			
			errors.add("Partner Name is mandatory and have minimum 5 characters");
		}
		else if( City != null && City.length() >= 3 ) {
			
			errors.add("City is mandatory and have minimum 3 characters");
		}
		else if( StateProperties != null && StateProperties.length() >= 3) {
			
			errors.add("State is mandatory and have minimum 3 characters");
		}
		return errors.toArray(new String[0]);
		
	}

}
