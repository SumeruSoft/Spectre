package com.sumeru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee extends BaseCarRentalObject {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "login"  ,nullable = false)//, unique=true, nullable = false)
	private String login;
	
	@Column(name = "passwd"  , nullable = false)
	private String passwd;
	
	@Column(name = "mobile")
	private int mobile;
	
	@Column(name = "role")
	private String role;
	
	
	public Employee(String name, String login, String passwd, String role,
			String status) {
		super();
		this.name = name;
		this.login = login;
		this.passwd = passwd;
		this.role = role;
		setStatus(status);
	}

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", login=" + login + ", passwd="
				+ passwd + ", mobile=" + mobile + ", role=" + role
				+ ", toString()=" + super.toString() + "]";
	}


	
	

}
