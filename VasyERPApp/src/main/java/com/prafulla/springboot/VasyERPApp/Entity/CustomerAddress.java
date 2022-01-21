
package com.prafulla.springboot.VasyERPApp.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_address")
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="addressId")
	private int addressId;
	
	@Column(name = "address")
	private String address;

	@Column(name = "state")
	private String state;

	
	@Column(name = "city")
	private String city; 

	@Column(name = "pincode")
	private String pincode;
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name="custom_id")
	private Customer customer;
	
public CustomerAddress()
{
	
}

	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public CustomerAddress(int addressId, String address, String state, String city, String pincode,
			Customer customer) {
		super();
		this.addressId = addressId;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "CustomerAddress [addressId=" + addressId + ", address=" + address + ", state=" + state + ", city="
				+ city + ", pincode=" + pincode + ", customer=" + customer + "]";
	}

	
	

	

}