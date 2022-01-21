package com.prafulla.springboot.VasyERPApp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prafulla.springboot.VasyERPApp.Entity.Customer;
import com.prafulla.springboot.VasyERPApp.Entity.CustomerAddress;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager entityManager;
	

	@Autowired
	public CustomerDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	
	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		
		//getting hibernate session
		
		Session sess = entityManager.unwrap(Session.class);
		
		Query<Customer> query = sess.createQuery("from Customer",Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		
		//crete a query
		
		//reutning values
		return customers;
	}


	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
		Session sess = entityManager.unwrap(Session.class);
		Customer customer =sess.get(Customer.class, id);
		
		  List<CustomerAddress> addresses = customer.getAddresses();
		  
		 if(addresses !=null) { for(CustomerAddress customerAddress:addresses) {
		  CustomerAddress customerAdress =
		  sess.get(CustomerAddress.class,customerAddress.getAddressId() );
		  sess.delete(customerAdress);
		  
		  }
		  
		  }
		 
			sess.delete(customer);
	
	}


	@Transactional
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Session sess = entityManager.unwrap(Session.class);
		sess.saveOrUpdate(customer);
		
		List<CustomerAddress> addresses =  customer.getAddresses();
		
		if(addresses !=null)
		{
			
			for(CustomerAddress customerAddress:addresses)
			{
			customerAddress.setCustomer(customer);
				sess.saveOrUpdate(customerAddress);
			}
		
		}
		
	}




}
