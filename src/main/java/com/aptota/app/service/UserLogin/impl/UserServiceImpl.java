package com.aptota.app.service.UserLogin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.UserDao;
import com.aptota.app.model.User;
import com.aptota.app.model.UIModel.UIUser;
import com.aptota.app.model.response.Response;
import com.aptota.app.service.UserLogin.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public Response saveWebUser(UIUser webUserModel, String userName) {
		
		Response response = userDao.saveWebUser(webUserModel, userName);
		return response;
	}

	@Override
	public List<User> getexecutiveUsers() {
		return userDao.getAllExecutiveUsers();
	}

	@Override
	public Response saveSalesUser(UIUser salesUserModel, String userName) {
		// TODO Auto-generated method stub
		return userDao.saveSalesPerson(salesUserModel, userName);
	}

	@Override
	public List<User> getSalesUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllSalesPersons();
	}


}
