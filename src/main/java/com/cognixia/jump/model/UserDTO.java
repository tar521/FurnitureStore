package com.cognixia.jump.model;

public class UserDTO {
	
	private String username;
	
	private String name;
	
	private String email;
	
	private String role;
	
	public UserDTO() {}
	
	public UserDTO(User user) {
		this.username = user.getUsername();
		this.name = user.getName();
		this.email = user.getEmail();
		this.role = user.getRole().toString();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
	

}
