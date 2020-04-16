package com.aptota.app.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@Autowired
	
	
//	@RequestMapping("/")
//	public String home() {
//		
//		return ("dashboard");
//	}
	
	 @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	    public ModelAndView home(HttpServletRequest request) {
	        ModelAndView view = new ModelAndView();
	       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        
	        if(!(auth instanceof AnonymousAuthenticationToken)) {
	       if(auth != null) {
	    	   UserDetails userDetails = (UserDetails) auth.getPrincipal();
	    	   Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
	           System.out.println("success");
	           String username = userDetails.getUsername();
	           request.getSession().setAttribute("username", userDetails.getUsername());
	           request.getSession().setAttribute("userrole", authorities);
	           
	       }else System.out.println(auth);


	        }
	        

	        view.setViewName("dashboard");
	        return view;
	    }
	 
	@RequestMapping("/login")
	public String loginPage() {
		
		return "login";
	}
	
	@RequestMapping("/logout-success")
	public String logoutSuccessPage() {
		
		return "logout";
	}
	
	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public String logout(HttpServletRequest request, HttpServletResponse response) {

	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if(authentication != null) {

	            new SecurityContextLogoutHandler().logout(request, response, authentication);
	        }
	        request.getSession().invalidate();
	        return "redirect:/";
	    }


}
