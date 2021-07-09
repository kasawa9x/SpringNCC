package com.example.demospringncc.dto;

import lombok.Data;

@Data
public class UserDTO {

	private String firstName;

	private String lastName;


	private String userName;
	private String password;

	public UserDTO(){
	}

	public UserDTO(String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String email) {
//		this.userName = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
}
