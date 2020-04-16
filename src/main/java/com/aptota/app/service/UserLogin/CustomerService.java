package com.aptota.app.service.UserLogin;

import java.util.List;

import com.aptota.app.model.Customer;
import com.aptota.app.model.response.Response;

public interface CustomerService {
	
	public Response registercustomer(Customer customer);
	public List<Customer> getAllCustomersServ();
	public List<String> serachCustomer(String term);
	public Response getCustomerByNic (String nic);

}
