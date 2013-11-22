package cs445.project.base;

import java.util.Date;

public class User {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String ccNumber;
	private Date   ccExpiryDate;
	private Integer securityCode;
	private String  phone;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public Date getCcExpiryDate() {
		return ccExpiryDate;
	}
	public void setCcExpiryDate(Date ccExpiryDate) {
		this.ccExpiryDate = ccExpiryDate;
	}
	public Integer getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", ccNumber="
				+ ccNumber + ", ccExpiryDate=" + ccExpiryDate
				+ ", securityCode=" + securityCode + ", phone=" + phone + "]";
	}
	
	
}
