package com.users;

public class SapientUsers {
	int userId;
	String userName;
	String userPassword;
	String userGender;
	long userPhone;
	String userAddress;
	String userEmail;
	String userSapientEmail;
	int scopeId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public long getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserSapientEmail() {
		return userSapientEmail;
	}
	public void setUserSapientEmail(String userSapientEmail) {
		this.userSapientEmail = userSapientEmail;
	}
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}
	@Override
	public String toString() {
		return "SapientUsers [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userGender="
				+ userGender + ", userPhone=" + userPhone + ", userAddress="
				+ userAddress + ", userEmail=" + userEmail
				+ ", userSapientEmail=" + userSapientEmail + ", scopeId="
				+ scopeId + "]";
	}
	

}
