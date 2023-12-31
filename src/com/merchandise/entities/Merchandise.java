package com.merchandise.entities;

import java.util.ArrayList;
import java.util.List;

public class Merchandise {

	//class “Merchandise” with partnerId, partnerName, City, State properties
	
	public int partnerId;
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
		
		if( partnerId <= 0 ) {
			errors.add("Partner Id is mandatory and must be a positive number");
		}
		else if( partnerName.length() < 5 ) {
			errors.add("Partner Name is mandatory and have minimum 5 characters");
		}
		else if( City.length() < 3 ) {
			errors.add("City is mandatory and have minimum 3 characters");
		}
		else if( StateProperties.length() < 3) {
			errors.add("State is mandatory and have minimum 3 characters");
		}
		return errors.toArray(new String[0]);
		
	}
	
	public void printInfo() {
		System.out.println("Partner Id: " + partnerId);
		System.out.println("Partner Name: " + partnerName);
		System.out.println("City: " + City);
		System.out.println("State: " + StateProperties);
	}

}
