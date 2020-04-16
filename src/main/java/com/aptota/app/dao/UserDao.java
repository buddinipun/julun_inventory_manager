package com.aptota.app.dao;

import com.aptota.app.model.Customer;
import com.aptota.app.model.User;
import com.aptota.app.model.UIModel.UIUser;
import com.aptota.app.model.response.Response;

import java.util.List;

public interface UserDao {

 
    public Response saveWebUser(UIUser webUserModel, String userName);
    public List<User> getAllExecutiveUsers();
    public Response saveSalesPerson(UIUser agentUserModel, String userName);
    public List<User> getAllSalesPersons();
    public String findUserRoleById(int roleId);
}
