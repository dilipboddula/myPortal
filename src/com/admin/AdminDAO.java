package com.admin;

import java.util.ArrayList;


public interface AdminDAO {
	int addAdmin(Admin a);
	ArrayList<Admin> adminLogin(String adminUserName);
	int addPoc(int scopeId,int nomineeId);
	ArrayList<Admin> getAllAdmins(int scopeId);
	int changePassword(int id,int scopeId,String newPassword,String curPassword);

}
