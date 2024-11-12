package com.app.blogger.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(nullable = false)
	private String firstName;
	private String lastName;
	
	@Column(nullable = false)
    @Email(message = "Invalid email address")
	private String email;
	private String about;

	@Column(nullable = false)
	private String password;
	private String mobileNo;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true,mappedBy = "user",fetch = FetchType.LAZY)
	private Set<Post> allPostByUser = new HashSet<>();	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, @Email(message = "Invalid email address") String email, String about,
			String password, String mobileNo, Set<Post> allPostByUser) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.about = about;
		this.password = password;
		this.mobileNo = mobileNo;
		this.allPostByUser = allPostByUser;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Set<Post> getAllPostByUser() {
		return allPostByUser;
	}

	public void setAllPostByUser(Set<Post> allPostByUser) {
		this.allPostByUser = allPostByUser;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", about=" + about + ", password=" + password + ", mobileNo=" + mobileNo + ", allPostByUser="
				+ allPostByUser + "]";
	}
	
	
	
	
	
}
