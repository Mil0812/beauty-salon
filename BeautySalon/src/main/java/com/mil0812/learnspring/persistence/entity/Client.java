package com.mil0812.learnspring.persistence.entity;

public class Client extends Entity{
	private String fullName;
	private String phoneNumber;
	private String password;

	public Client(Integer id, String fullName, String phoneNumber, String password) {
		super(id);
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client{" +
		    "fullName='" + fullName + '\'' +
		    ", phoneNumber='" + phoneNumber + '\'' +
		    ", password='" + password + '\'' +
		    '}';
	}
}
