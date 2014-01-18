package com.voteForPoc;

public class Votes {
	int voteId;
	int voteCompId;
	int scopeId;
	int nominatorId;
	String nominatorName;
	int nomineeId;
	String nomineeName;
	String comment;
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public int getVoteCompId() {
		return voteCompId;
	}
	public void setVoteCompId(int voteCompId) {
		this.voteCompId = voteCompId;
	}
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}
	public int getNominatorId() {
		return nominatorId;
	}
	public void setNominatorId(int nominatorId) {
		this.nominatorId = nominatorId;
	}
	public String getNominatorName() {
		return nominatorName;
	}
	public void setNominatorName(String nominatorName) {
		this.nominatorName = nominatorName;
	}
	public int getNomineeId() {
		return nomineeId;
	}
	public void setNomineeId(int nomineeId) {
		this.nomineeId = nomineeId;
	}
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Votes [voteId=" + voteId + ", voteCompId=" + voteCompId
				+ ", scopeId=" + scopeId + ", nominatorId=" + nominatorId
				+ ", nominatorName=" + nominatorName + ", nomineeId="
				+ nomineeId + ", nomineeName=" + nomineeName + ", comment="
				+ comment + "]";
	}
	
	

}
