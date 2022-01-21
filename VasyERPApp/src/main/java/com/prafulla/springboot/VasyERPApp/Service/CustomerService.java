package com.prafulla.springboot.VasyERPApp.Service;

import java.util.List;

import com.prafulla.springboot.VasyERPApp.Entity.Customer;

public interface CustomerService {
	
	
	public List<Customer> getAllCustomers();
	
	public void deleteCustomer(int id);
	
	public void addCustomer(Customer customer);
	

}
