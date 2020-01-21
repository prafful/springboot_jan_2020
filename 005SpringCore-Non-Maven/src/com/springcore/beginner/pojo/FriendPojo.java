package com.springcore.beginner.pojo;

public class FriendPojo {

	private String name;
	private String location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public FriendPojo(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	public FriendPojo() {
		super();
	
	}
	
	
}
