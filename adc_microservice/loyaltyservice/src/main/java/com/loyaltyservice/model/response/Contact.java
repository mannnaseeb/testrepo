package com.loyaltyservice.model.response;
public class Contact{
    public String firstName;
    public String lastName;
    public String emailAddress;
    public String phoneNumber;
    public Long userId;
    public Long contactId;
    public boolean emailModified;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public boolean isEmailModified() {
		return emailModified;
	}
	public void setEmailModified(boolean emailModified) {
		this.emailModified = emailModified;
	}
    
    
}