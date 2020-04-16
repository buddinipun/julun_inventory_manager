package com.aptota.app.dao;

import java.util.List;

import com.aptota.app.model.Customer;
import com.aptota.app.model.response.Response;

public interface CustomerDao {
	
	Response saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	public List<String> searchCustomer(String q);
	public Response getCustomerByNic(String nic);


}
