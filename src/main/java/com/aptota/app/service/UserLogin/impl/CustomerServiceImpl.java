package com.aptota.app.service.UserLogin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.CustomerDao;
import com.aptota.app.model.Customer;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.UserLogin.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public Response registercustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Response response = customerDao.saveCustomer(customer);
		return response;
	}

	@Override
	public List<Customer> getAllCustomersServ() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public List<String> serachCustomer(String term) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomer(term);
	}

	@Override
	public Response getCustomerByNic(String nic) {
		return customerDao.getCustomerByNic(nic);
	}


}
