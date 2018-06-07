package com.forezp.entity;

public class UserInfo {
	private String name1;
	private String departName;
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public UserInfo() {
	}
	@Override
	public String toString() {
		return "UserInfo [name1=" + name1 + ", departName=" + departName + "]";
	}
	
}
