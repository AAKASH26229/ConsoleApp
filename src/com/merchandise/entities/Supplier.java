package com.merchandise.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Supplier extends Merchandise{

	//For Supplier class: CreditBalance, DrivingLicenseNumber
	private int CreditBalance;
	private String DrivingLicenseNumber;
	
	
	public Supplier(int partnerId, String partnerName, String City, String StateProperties,
            int creditBalance, String drivingLicenseNumber) {
		super(partnerId, partnerName, City, StateProperties);
		CreditBalance = creditBalance;
		DrivingLicenseNumber = drivingLicenseNumber;
	}
	
	// Function to validate
    // Indian driving license number
    // using regular expression
    public static boolean isValidLicenseNo(String str)
    {
        // Regex to check valid
        // Indian driving license number
        String regex = "^(([A-Z]{2}[0-9]{2})"
                       + "( ))"
                       + "[0-9]{11}$";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }
 
        // Find match between given string
        // and regular expression
        // uSing Pattern.matcher()
 
        Matcher m = p.matcher(str);
 
        // Return if the string
        // matched the ReGex
        return m.matches();
    }
		
		@Override
		public String[] Validate() {
		List<String> errors = new ArrayList<>();
		
		   // Invoke base class validation
        String[] baseValidationErrors = super.Validate();
        for (String error : baseValidationErrors) {
            errors.add(error);
        }
		
		if( CreditBalance >  175000 ) {
			errors.add("Credit Balance not exceed 1,75,000.");
		}
		else if(!isValidLicenseNo(DrivingLicenseNumber)) {
			errors.add("Enter Valid Driving License Number.");
		}

		return errors.toArray(new String[0]);
		
	}
	
		@Override
		public void printInfo() {
			super.printInfo();
			System.out.println("Credit Balance: "+CreditBalance);
			System.out.println("Driving License Number: "+DrivingLicenseNumber);
		}
	
}

