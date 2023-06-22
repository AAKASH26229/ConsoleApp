package com.merchandise.services;

import java.util.ArrayList;
import java.util.List;

import com.merchandise.entities.Customer;
import com.merchandise.entities.Supplier;

public class MerchandiseService {

	
	private List<Customer> customers;
	private List<Supplier> suppliers;

	public MerchandiseService() {
		customers = new ArrayList<>();
		suppliers = new ArrayList<>();
	}
	
	// saving customer details
	public void SaveCustomerDetails(Customer cust) {
		customers.add(cust);
	}
	
	// Return list of customers
	public List<Customer> GetAllCustomers() {
		return customers;
	}
	
	// Return customer by customerId
	public Customer GetCustomerById(int customerid) {
		return customers.stream().filter(cust -> cust.partnerId == customerid).findFirst().orElse(null);
	}
	
	// Saving supplier Details
	public void SaveSupplierDetails(Supplier sup) {
		suppliers.add(sup);
	}
	
	
}