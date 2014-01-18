package com.awards;

import java.util.ArrayList;
import java.util.List;

import com.users.SapientUsers;


public interface AwardsDAO {
	
		
	boolean addNominees(int nominatorId,int nomineeArray[],String reasonArray[],int scopeId,String impactArray[]);
	ArrayList<Awards> getAllNominees(int scopeId);
	List getTop5Creativity(int scopeId);
	ArrayList<Awards> getComments(int nomineeId,int coreValueId);
	boolean checkAwardsDuplicate(int nominatorId);
	ArrayList<Integer> getAwardStats(int scopeId);

}
