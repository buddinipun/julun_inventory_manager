package com.aptota.app.model.response;

import com.aptota.app.model.Customer;
import com.aptota.app.model.Item;

public class AjaxResponse {

    private String resString;
    private boolean validated;
    private String message;
    private Customer customer;
    private Item item;
    private Response response;

    public AjaxResponse(String resString, boolean validated) {
        this.resString = resString;
        this.validated = validated;
    }
    public AjaxResponse(String message, Customer customer) {
        this.message = message;
        this.customer = customer;
    }
    
    public AjaxResponse(String message, Item item) {
    	
    	this.message = message;
    	this.item = item;
    }
    
    
    public AjaxResponse(String message, Response response,boolean validated) {
		super();
		this.validated = validated;
		this.message = message;
		this.response = response;
	}
	public String getResString() {
        return resString;
    }

    public void setResString(String resString) {
        this.resString = resString;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	
	
    
    
}
