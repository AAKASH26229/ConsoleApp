package com.merchandise.consolepack;

import java.util.List;
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
					System.out.println("Maximum number of customers reached.");
				}
				break;
			case 2:
				if(merchandiseService.GetAllSuppliers().size() < Limit ) {
					Supplier supplier = createSupplier(sc);
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
					System.out.println("Maximum number of suppliers reached.");
				}
				break;
			case 3:
				displayCustomerReport(merchandiseService.GetAllCustomers());
				break;
			case 4:
				displaySupplierReport(merchandiseService.GetAllSuppliers());
				break;
			case 5:
				searchCustomer(sc, merchandiseService);
				break;
			case 6:
				searchSupplier(sc, merchandiseService);
			case 7:
				System.out.println("Exit!");
				break;
			default:
				System.out.println("Invalid choice! Try again");
			}
		} while(choice != 7);
		
		sc.close();
	}
	
	private static Customer createCustomer(Scanner sc) {
		System.out.println("Enter Customer Details: ");
		System.out.print("Enter Partner Id: ");
		int partnerId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Partner Name: ");
		String partnerName = sc.nextLine();
		
		System.out.print("Enter City: ");
		String city = sc.nextLine();
		
		System.out.print("Enter State: ");
		String state = sc.nextLine();
		
		System.out.print("Enter Credit Limit: ");
		int creditLimit = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Phone Number: ");
		String phoneNumber = sc.nextLine();
		
		System.out.print("Enter Email: ");
		String email = sc.nextLine();
		
		return new Customer(partnerId, partnerName, city, state, creditLimit, phoneNumber, email);
			
	}
	
	private static Supplier createSupplier(Scanner sc) {
		System.out.println("Enter Supplier Details: ");
		System.out.print("Enter Partner Id: ");
		int partnerId = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Partner Name: ");
		String partnerName = sc.nextLine();
		
		System.out.print("Enter City: ");
		String city = sc.nextLine();
		
		System.out.print("Enter State: ");
		String state = sc.nextLine();
		
		System.out.print("Enter Credit Balance: ");
		int creditBalance = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter Valid Driving License Number: ");
		String drivingLicenseNumber = sc.nextLine();
		
		return new Supplier(partnerId, partnerName, city, state, creditBalance, drivingLicenseNumber);
	
	}
	
	private static void displayCustomerReport(List<Customer> customers) {
		if(customers.isEmpty()) {
			System.out.println("No customer details found!");
		}
		else {
			System.out.println("Customer Report: ");
			for(Customer cust : customers) {
				cust.printInfo();
				System.out.println();
			}
		}
	}
	
	
	private static void displaySupplierReport(List<Supplier> suppliers) {
		if(suppliers.isEmpty()) {
			System.out.println("No supplier details found!");
		}
		else {
			System.out.println("Supplier Report: ");
			for(Supplier sup : suppliers) {
				sup.printInfo();
				System.out.println();
			}
		}
	}
	
	private static void searchCustomer(Scanner sc, MerchandiseService merchandiseService) {
		System.out.print("Enter Customer Id to search: ");
		int customerId = sc.nextInt();
		sc.nextLine();
		
		Customer cust = merchandiseService.GetCustomerById(customerId);
		if( cust == null ) {
			System.out.println("Customer not found!");
		}
		else {
			System.out.println("Customer Details: ");
			cust.printInfo();
			System.out.println();
		}
	}
	
	private static void searchSupplier(Scanner sc, MerchandiseService merchandiseService) {
		System.out.print("Enter Supplier Id to search: ");
		int supplierId = sc.nextInt();
		sc.nextLine();
		
		Supplier sup = merchandiseService.GetSupplierById(supplierId);
		if( sup == null ) {
			System.out.println("Supplier not found!");
		}
		else {
			System.out.println("Supplier Details: ");
			sup.printInfo();
			System.out.println();
		}
		
	}
	
}
