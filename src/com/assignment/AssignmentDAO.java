package com.assignment;

import java.util.ArrayList;
import java.util.Date;



public interface AssignmentDAO {
	boolean addAssignment(Assignment a);
	ArrayList<Assignment> getAllAssignments(int scopeId);
	int submitAssigment(int scopeId,int assignmentId,int member1Id,int member2Id,String projectName,
			String fileName,String projectDescription,String url);
	ArrayList<SubmitAssignment> getAllSubmittedAssignments(int scopeId);

}

