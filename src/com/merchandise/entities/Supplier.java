package com.merchandise.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Supplier extends Merchandise{

	//For Supplier class: CreditBalance, DrivingLicenseNumber
	private double CreditBalance;
	private String DrivingLicenseNumber;
	
	
	public Supplier(double creditBalance, String drivingLicenseNumber) {
		super();
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
                       + "( )|([A-Z]{2}-[0-9]"
                       + "{2}))((19|20)[0-9]"
                       + "[0-9])[0-9]{7}$";
 
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
		List<String> error = new ArrayList<>();
		
//		   // Invoke base class validation
//        String[] baseValidationErrors = super.Validate();
//        for (String error : baseValidationErrors) {
//            errors.add(error);
//        }
		
		if( CreditBalance <= 175000 ) {
			error.add("Credit Balance not exceed 1,75,000.");
		}
		else if(!isValidLicenseNo(DrivingLicenseNumber)) {
			error.add("Enter Valid Driving License Number.");
		}

		return error.toArray(new String[0]);
		
	}
	
		@Override
		public void printInfo() {
			System.out.println("Credit Balance: "+CreditBalance);
			System.out.println("Driving License Number: "+DrivingLicenseNumber);
		}
	
}

