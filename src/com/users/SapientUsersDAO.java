package com.users;

import java.util.ArrayList;

public interface SapientUsersDAO {
	int addUser(SapientUsers s);
	ArrayList<SapientUsers> userLogin(String email);
	int checkMailIdInNames(String sapientEmail);
	ArrayList<SapientUsers> getAllUsers(int scopeId);
	int changePassword(int id,int scopeId,String newPassword,String curPassword);
	

}
