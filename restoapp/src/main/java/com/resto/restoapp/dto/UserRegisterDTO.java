package com.resto.restoapp.dto;

public class UserRegisterDTO {

	private Long id;
	private String name;
	private String lastName;
	private String password;
	private String user;

	public UserRegisterDTO() {
		super();
	}

	public UserRegisterDTO(String user) {
		super();
		this.user = user;
	}

	public UserRegisterDTO(Long id, String name, String lastName, String password, String user) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
