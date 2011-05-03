package com.softbeacon.webapp.beans;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
public class User {

	private Integer idusers;
	
	@Length(min=6,max=16)
	private String username;
	
	@NotEmpty
	private String firstname;
	
	@NotEmpty
	private String lastname;
	
	@Pattern(regexp="[M|F]")
	private String sex;
	
	@NotNull
	@Digits(integer=2,fraction=0)
	private Integer age;
	
	@Pattern(regexp="[0-9]{5}")
	private String zipcode;

	@NotEmpty
	@Email
	private String email;
	
	private Date datecreated;
	private String printbadge;
	
	public User(){
		
	}
	
	public Integer getIdusers() {
		return idusers;
	}
	public void setIdusers(Integer idusers) {
		this.idusers = idusers;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}
	public String getPrintbadge(){
		StringBuffer printMessage = new StringBuffer();
		printMessage.append("\n");
		printMessage.append("User Id: ").append(this.idusers).append("\n");
		printMessage.append("Username: ").append(this.username).append("\n");
		printMessage.append("Firstname: ").append(this.lastname).append("\n");
		printMessage.append("Lastname: ").append(this.firstname).append("\n");
		printMessage.append("Sex: ").append(this.sex).append("\n");
		printMessage.append("Age: ").append(this.age).append("\n");
		printMessage.append("Zipcode: ").append(this.zipcode).append("\n");
		printMessage.append("Email: ").append(this.email).append("\n");
		printMessage.append("DateCreated: ").append(this.datecreated).append("\n");

		this.printbadge = printMessage.toString();
		return printbadge;
	}
	
}
