package com.merchandise.entities;

public class Customer extends Merchandise {

	//Customer class: creditLimit, phoneNumber, email
	private int creditLimit;
	private String phoneNumber;
	private String email;
	
	
	public Customer(int creditLimit, String phoneNumber, String email) {
		super();
		this.creditLimit = creditLimit;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	@Override
	public String[] Validate() {
		
		
		return null;
		
	}
	
	
	
	
}
