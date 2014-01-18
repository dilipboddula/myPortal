package com.admin;

public class Admin {
	int adminId;
	String adminUserName;
	String adminPassword;
	String adminRole;
	int scopeId;
	int uploadTrigger;
	public int getUploadTrigger() {
		return uploadTrigger;
	}
	public void setUploadTrigger(int uploadTrigger) {
		this.uploadTrigger = uploadTrigger;
	}
	@Override
	public String toString() {
		return "admin [adminId=" + adminId + ", adminUserName=" + adminUserName
				+ ", adminPassword=" + adminPassword + ", adminRole="
				+ adminRole + ", scopeId=" + scopeId + "]";
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}

}
