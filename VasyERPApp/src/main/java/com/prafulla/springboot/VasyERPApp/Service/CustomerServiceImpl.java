package com.prafulla.springboot.VasyERPApp.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prafulla.springboot.VasyERPApp.DAO.CustomerDAO;
import com.prafulla.springboot.VasyERPApp.Entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerDAO customerDAO;
	

	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		return customerDAO.getAllCustomers();
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(id);

	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		customerDAO.addCustomer(customer);

	}

}
