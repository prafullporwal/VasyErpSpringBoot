package com.prafulla.springboot.VasyERPApp.DAO;

import java.util.List;

import com.prafulla.springboot.VasyERPApp.Entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomers();
	
	public void deleteCustomer(int id);
	
	public void addCustomer(Customer customer);
	
	

}
