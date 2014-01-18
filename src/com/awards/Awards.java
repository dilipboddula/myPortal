package com.awards;

public class Awards {
	int scopeId;
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}
	int awardId;
	int nominatorId;
	int nomineeId;
	int coreValueId;
	String reason;
	String coreValue;
	String nominatorName;
	String nomineeName;
	String impact;
	public String getImpact() {
		return impact;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	public String getNominatorName() {
		return nominatorName;
	}
	public void setNominatorName(String nominatorName) {
		this.nominatorName = nominatorName;
	}
	public String getNomineeName() {
		return nomineeName;
	}
	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}
	public String getCoreValue() {
		return coreValue;
	}
	public void setCoreValue(String coreValue) {
		this.coreValue = coreValue;
	}
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	public int getNominatorId() {
		return nominatorId;
	}
	public void setNominatorId(int nominatorId) {
		this.nominatorId = nominatorId;
	}
	public int getNomineeId() {
		return nomineeId;
	}
	public void setNomineeId(int nomineeId) {
		this.nomineeId = nomineeId;
	}
	public int getCoreValueId() {
		return coreValueId;
	}
	public void setCoreValueId(int coreValueId) {
		this.coreValueId = coreValueId;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "Awards [awardId=" + awardId + ", nominatorId=" + nominatorId
				+ ", nomineeId=" + nomineeId + ", coreValueId=" + coreValueId
				+ ", reason=" + reason + ", coreValue=" + coreValue
				+ ", nominatorName=" + nominatorName + ", nomineeName="
				+ nomineeName + "]";
	}
	

	
	

}
