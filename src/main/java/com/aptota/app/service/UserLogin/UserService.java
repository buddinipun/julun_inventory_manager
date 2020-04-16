package com.aptota.app.service.UserLogin;

import com.aptota.app.model.User;
import com.aptota.app.model.UIModel.UIUser;
import com.aptota.app.model.response.Response;

import java.util.List;

public interface UserService {
	
	public Response saveWebUser(UIUser webUserModel, String userName);
	public List<User> getexecutiveUsers();
	public Response saveSalesUser(UIUser salesUserModel, String userName);
	public List<User> getSalesUsers();

}
