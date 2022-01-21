package com.prafulla.springboot.VasyERPApp.Entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_id")
	private int customerId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Mobile_No")
	private String mobileNo;

	@Column(name = "Email_id")
	private String emailid;

	public List<CustomerAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<CustomerAddress> addresses) {
		this.addresses = addresses;
	}

	@OneToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name = "custom_id")
	private List<CustomerAddress> addresses;

	public void addAddress(CustomerAddress address) {
		if (addresses == null) {
			addresses = new LinkedList<CustomerAddress>();
		} 
			addresses.add(address);
			
			address.setCustomer(this);
		
	}

	public Customer() {

	}

	public Customer(int customerId, String name, String mobileNo, String emailid, List<CustomerAddress> addresses) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailid = emailid;
		this.addresses = addresses;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getemailid() {
		return emailid;
	}

	public void setemailid(String emailid) {
		this.emailid = emailid;
	}

	

	

	

}
