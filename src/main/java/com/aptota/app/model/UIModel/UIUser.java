package com.aptota.app.model.UIModel;


import java.sql.Timestamp;


public class UIUser {
    private String uname;
    private String password;
    private String fname;
    private String lname;
    private String contactNo;
    private String isactive;
    private Timestamp cDate;
    private Long branchCode;
    private String email;
    private Long enabled;
    private String userRole;
    private Long salesPerson;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public Timestamp getcDate() {
		return cDate;
	}
	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}
	public Long getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(Long branchCode) {
		this.branchCode = branchCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getEnabled() {
		return enabled;
	}
	public void setEnabled(Long enabled) {
		this.enabled = enabled;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Long getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(Long salesPerson) {
		this.salesPerson = salesPerson;
	}
	

 
   
}
