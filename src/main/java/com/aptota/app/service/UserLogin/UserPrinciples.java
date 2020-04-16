package com.aptota.app.service.UserLogin;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aptota.app.model.User;

import ch.qos.logback.core.net.SyslogOutputStream;

public class UserPrinciples implements UserDetails {
	
	User user;
	

	public UserPrinciples(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		System.out.println("user role is : " + user.getUserroles().get(0));
		String userRole = user.getUserroles().get(0);
		return Collections.singleton(new SimpleGrantedAuthority(userRole));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
