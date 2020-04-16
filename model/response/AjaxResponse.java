package com.aptota.app.model.response;



public class AjaxResponse {

    private String resString;
    private boolean validated;
    private String message;
    private Response response;

    public AjaxResponse(String resString, boolean validated) {
        this.resString = resString;
        this.validated = validated;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	
	
    
    
}
