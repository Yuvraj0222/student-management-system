package net.guides.springboot2.springboot2jpacrudexample.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

	private long id;
	private String fname;
	private String lname;
	private String email;

	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String emailId) {
		this.fname = firstName;
		this.lname = lastName;
		this.email =emailId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {

		this.fname = fname;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + fname + ", lastName=" + lname + ", emailId=" + email
				+ "]";
	}
	
}
