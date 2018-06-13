package com.forezp.entity;

public class UserInfo {
	private Integer id;
	private String name;
	private String departName;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "UserInfo [id=" + id + ", name=" + name + ", departName=" + departName + "]";
	}
	
}
