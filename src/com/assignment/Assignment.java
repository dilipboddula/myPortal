package com.assignment;

import java.util.Date;


public class Assignment {
int scopeId;
public int getScopeId() {
	return scopeId;
}
public void setScopeId(int scopeId) {
	this.scopeId = scopeId;
}
String assignment;
int assignmentId;
Date date;

public String getAssignment() {
       return assignment;
}
public void setAssignment(String assignment) {
       this.assignment = assignment;
}
public int getAssignmentId() {
       return assignmentId;
}
public void setAssignmentId(int assignmentId) {
       this.assignmentId = assignmentId;
}
public Date getDate() {
       return date;
}
public void setDate(Date date2) {
       this.date = date2;
}

}
