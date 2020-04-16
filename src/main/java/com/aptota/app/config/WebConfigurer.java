package com.aptota.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@SuppressWarnings("deprecation")
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {
	
	
	 @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resource/**").addResourceLocations("/public/");
	  
	  }
	 
	 @Override
		public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/home").setViewName("dashboard");
		 registry.addViewController("/").setViewName("dashboard");
		 registry.addViewController("/hello").setViewName("hello");
		 registry.addViewController("/login").setViewName("login");
		 registry.addViewController("/403").setViewName("403");
		// registry.addViewController("/singup").setViewName("signup");
		}
	 
	 
	 @Bean
	 public InternalResourceViewResolver viewResolver() {
		 
		 	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 	resolver.setPrefix("/WEB-INF/jsp/");
		 	resolver.setSuffix(".jsp");
		 	
		 	return resolver;
	 }

}
