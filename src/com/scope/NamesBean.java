package com.scope;

public class NamesBean {
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String name;
	int scopeId;
	String sapientEmail;
	public String getSapientEmail() {
		return sapientEmail;
	}
	public void setSapientEmail(String sapientEmail) {
		this.sapientEmail = sapientEmail;
	}
	@Override
	public String toString() {
		return "NamesBean [name=" + name + ", scopeId=" + scopeId + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScopeId() {
		return scopeId;
	}
	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}

}
