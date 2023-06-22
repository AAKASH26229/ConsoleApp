package com.merchandise.consolepack;

import java.util.Scanner;

import com.merchandise.entities.Customer;
import com.merchandise.entities.Supplier;
import com.merchandise.services.MerchandiseService;

public class ConsoleApplication {

	//Limit array to 5 items
	private static final int Limit=5;
	
	public static void main(String[] args) {
		
		MerchandiseService merchandiseService = new MerchandiseService();
		
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do {
			System.out.println("Menu: ");
			System.out.println("1. Add Customer");
			System.out.println("2. Add Supplier");
			System.out.println("3. Display Customer Report");
			System.out.println("4. Display Supplier Report");
			System.out.println("5. Search Customer");
			System.out.println("6. Search Supplier");
			System.out.println("7. Exit");
			
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			
			
			switch(choice) {
			case 1:
				if(merchandiseService.GetAllCustomers().size() < Limit ) {
					Customer customer = createCustomer(sc);
					String[] validationErrors = customer.Validate();
					if(validationErrors.length == 0 ) {
						merchandiseService.SaveCustomerDetails(customer);
						System.out.println("Customer details added successfully.");
					} else {
						System.out.println("Validation errors:");
						for(String error : validationErrors) {
							System.out.println(error);
						}
					}
				} else {
					System.out.println("Maximum number of customer reached.");
				}
				break;
			case 2:
				if(merchandiseService.GetAllSuppliers().size() < Limit ) {
					Supplier supplier = createSupplier();
					String[] validationErrors = supplier.Validate();
					if(validationErrors.length == 0 ) {
						merchandiseService.SaveSupplierDetails(supplier);
						System.out.println("Supplier details added successfully.");
					} else {
						System.out.println("Validation errors:");
						for(String error : validationErrors) {
							System.out.println(error);
						}
					}
				} else {
					System.out.println("Maximum number of customer reached.");
				}
				break;
			}
		}
	}
}
