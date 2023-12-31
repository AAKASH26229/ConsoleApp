package com.merchandise.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer extends Merchandise {

	//Customer class: creditLimit, phoneNumber, email
	private int creditLimit;
	private String phoneNumber;
	private String email;
	

	public Customer(int partnerId, String partnerName, String City, String StateProperties,
			int creditLimit, String phoneNumber, String email) {
		super(partnerId, partnerName, City, StateProperties);
		this.creditLimit = creditLimit;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	private boolean isValidEmail(String email) {
	    String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	    Pattern pattern = Pattern.compile(emailRegex);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	} 
	
	@Override
	public String[] Validate() {
		List<String> errors = new ArrayList<>();
		
		
		   // Invoke base class validation
        String[] baseValidationErrors = super.Validate();
        for (String error : baseValidationErrors) {
            errors.add(error);
        }
		
		if( creditLimit > 50000 ) {
			errors.add("Credit Limit should not be greater than 50,000.");
		}
		else if( phoneNumber.length() != 10 ) {
			errors.add("Phone Number must have 10 digits.");
		}
		
		else if(!isValidEmail(email)) {
			errors.add("Enter valid email address.");
		}
		
		return errors.toArray(new String[0]);
		
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("Credit Limit: " + creditLimit);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
	}
	
	
	
	
}
