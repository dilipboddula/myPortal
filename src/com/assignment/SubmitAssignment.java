package com.assignment;

import java.util.Date;

public class SubmitAssignment {
	
	int submitId;
	int assignmentId;
	int member1Id;
	int member2Id;
	String member1Name;
	String member2Name;
	String projectName;
	String projectDescription;
	String fileName;
	String url;
	Date date;
	int scopeId;
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSubmitId() {
		return submitId;
	}
	public int getAssignmentId() {
		return assignmentId;
	}
	public int getMember1Id() {
		return member1Id;
	}
	public int getMember2Id() {
		return member2Id;
	}
	public String getMember1Name() {
		return member1Name;
	}
	public String getMember2Name() {
		return member2Name;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public String getFileName() {
		return fileName;
	}
	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public void setMember1Id(int member1Id) {
		this.member1Id = member1Id;
	}
	public void setMember2Id(int member2Id) {
		this.member2Id = member2Id;
	}
	public void setMember1Name(String member1Name) {
		this.member1Name = member1Name;
	}
	public void setMember2Name(String member2Name) {
		this.member2Name = member2Name;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "SubmitAssignment [submitId=" + submitId + ", assignmentId="
				+ assignmentId + ", member1Id=" + member1Id + ", member2Id="
				+ member2Id + ", member1Name=" + member1Name + ", member2Name="
				+ member2Name + ", projectName=" + projectName
				+ ", projectDescription=" + projectDescription + ", fileName="
				+ fileName + ", url=" + url + "]";
	}
	
	
	

}
