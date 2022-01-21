package com.prafulla.springboot.VasyERPApp.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prafulla.springboot.VasyERPApp.Entity.Customer;
import com.prafulla.springboot.VasyERPApp.Entity.CustomerAddress;
import com.prafulla.springboot.VasyERPApp.Service.CustomerService;

@Controller
@RequestMapping("/")
public class HomeController {

	private CustomerService customerService;

	@Autowired
	public HomeController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("/")
	public String showCustomerList(Model model) {

		List<Customer> customers = customerService.getAllCustomers();
		System.out.println("Customers List" + customers.toString());
		model.addAttribute("Customers", customers);
		return "customersHome";
	}
	

	@PostMapping("/addOrUpdateCustomer")
	public String addOrUpdateCustomer(HttpServletRequest req, Model mod) {
		System.out.println("Post Mapping");
		System.out.println("addCustomer");
		String ID = (String)req.getParameter("selectedCustomer");
		System.out.println("ID "+ID);
		Customer customer = new Customer();
		if(ID.equals(""))
		{
			customer.setName(req.getParameter("name"));
			customer.setMobileNo(req.getParameter("mobile_no"));
			customer.setemailid(req.getParameter("Email_id"));
			CustomerAddress address = new CustomerAddress();
			address.setAddress(req.getParameter("address"));
		//	address.setAddress("Address Added");
			System.out.println("get Address "+address.getAddress());
			//address.setAddressId(3);
			address.setCity("Indore");
			address.setState("MP");
			address.setPincode("453432");
			List<CustomerAddress> addressList = new LinkedList<CustomerAddress>();
			addressList.add(address);
			customer.setAddresses(addressList);
			System.out.println("Customer ID.equals(\\\"\\\") :" + customer.toString());
		}
		else
		{
			Integer id=Integer.valueOf(ID);
			System.out.println("id "+id);
			
			customer.setCustomerId(id);
			customer.setName(req.getParameter("name"+id));
			customer.setMobileNo(req.getParameter("mobile_no"+id));
			customer.setemailid(req.getParameter("Email_id"+id));
			
			CustomerAddress address;
			String [] addressIds =req.getParameterValues("addressId");
			if(addressIds != null)
			{
			System.out.println("addressIds size :" +addressIds.length);
			List<CustomerAddress> addressList = new ArrayList<CustomerAddress>();
			
			for (String addressid : addressIds) {
				address =new CustomerAddress();
				address.setAddress(req.getParameter("address"+addressid));
				System.out.println(address.getAddress());
				address.setAddressId(Integer.valueOf(addressid));
				System.out.println("address id set :"+address.getAddressId());
				//address.setCity("Indore");
				//address.setState("MP");
				//address.setPincode("453432");
				//address.setCustomerid(id);
			//	System.out.println("address.setCustomerid(id);"+address.getCustomerid());
				addressList.add(address);
			}

			customer.setAddresses(addressList);
			}
			
		
			System.out.println("Customer  :" + customer.toString());
		}
		

		customerService.addCustomer(customer);

		return "redirect:/";
	}

	@PostMapping("/deleteCustomer")
	public String deleteCustomer(HttpServletRequest req, Model mod) {
		System.out.println("Post Mapping");

		System.out.println("deleteCustomer");
		Integer id=Integer.valueOf((String)req.getParameter("selectedCustomer"));
		System.out.println("Customer id :"+id);
		customerService.deleteCustomer(id);
		return "redirect:/";
	}
	

}
