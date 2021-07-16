package com.app.dealer.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="firstname")
	private String fname;
	
	private String lname;
	
	private String age;
	
	private String email;
	
	private String phone;
	
	private String pass;
	
	private String grade;
	
	private String image;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String fname, String lname, String age, String email, String phone, String pass, String grade) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.pass = pass;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Account [fname=" + fname + ", lname=" + lname + ", age=" + age + ", email=" + email
				+ ", phone=" + phone + ", pass=" + pass + ", grade=" + grade + "]";
	}

	
	
	
	

}
