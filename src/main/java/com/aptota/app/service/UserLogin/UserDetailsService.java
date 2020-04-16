package com.aptota.app.service.UserLogin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aptota.app.dao.UserDao;
import com.aptota.app.dao.UserRepository;
import com.aptota.app.model.User;
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		
		//System.out.println("username is : " + user.getUsername());
		//System.out.println("userrole  is : " + user.getUserroles());
		
		if(user == null) 
			
			throw new UsernameNotFoundException("User 404");
		
		else {
			String userRole = userDao.findUserRoleById(user.getId());
			
		System.out.println("userRole on UserDetails call : " + userRole);
			  
			List<String> userRolesList = new ArrayList<String>();
			userRolesList.add(userRole);
			user.setUserroles(userRolesList);
			return new UserPrinciples(user);
			
		}
		
	}

}
