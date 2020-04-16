package com.aptota.app.model;

public class Response {
	
	private String message;
	private int resCode;
	private String resDes;
	private Object response;
	
	
	public Response(String message, int resCode, String resDes, Object response) {
		super();
		this.message = message;
		this.resCode = resCode;
		this.resDes = resDes;
		this.response = response;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResCode() {
		return resCode;
	}
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	public String getResDes() {
		return resDes;
	}
	public void setResDes(String resDes) {
		this.resDes = resDes;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	
	
	
	

}
