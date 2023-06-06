package com.webservice.IeltsWeb.Model;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;


@Entity
public class Account {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String iDString;
	
	private String userNameString;
	
	@JsonIgnore
	@Size(min = 6,message = "password must have six words")
	private String passwordString;
	@JsonIgnore
	private String nameString;
	@JsonIgnore
	private String avString;
	@JsonIgnore
	private String mailString;
	
	private String avarString;
	
	private String roleString;
	
	@OneToMany(mappedBy = "Owner")
	@JsonIgnore
	private List<Course> listCourse;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Cart> listCarts;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "iDAccount")
	private Set<Comment> MyComment;
	
	

	@JsonIgnore
	@OneToMany(mappedBy = "ID")
	private Set<Forum> listForum;
	
	
	
	
	public Set<Comment> getMyComment() {
		return MyComment;
	}

	public void setMyComment(Set<Comment> myComment) {
		MyComment = myComment;
	}

	public List<Course> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}

	public Set<Forum> getListForum() {
		return listForum;
	}

	public void setListForum(Set<Forum> listForum) {
		this.listForum = listForum;
	}

	public Set<Cart> getListCarts() {
		return listCarts;
	}

	public void setListCarts(Set<Cart> listCarts) {
		this.listCarts = listCarts;
	}

	public Account() {};
	
	public Account(String iDString, String userNameString,
			@Size(min = 6, message = "password must have six words") String passwordString, String nameString,
			String avString, String mailString, String avarString, String roleString) {
		super();
		this.iDString = iDString;
		this.userNameString = userNameString;
		this.passwordString = passwordString;
		this.nameString = nameString;
		this.avString = avString;
		this.mailString = mailString;
		this.avarString = avarString;
		this.roleString = roleString;
	}

	public String getiDString() {
		return iDString;
	}

	public void setiDString(String iDString) {
		this.iDString = iDString;
	}

	public String getUserNameString() {
		return userNameString;
	}

	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}

	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getAvString() {
		return avString;
	}

	public void setAvString(String avString) {
		this.avString = avString;
	}

	public String getMailString() {
		return mailString;
	}

	public void setMailString(String mailString) {
		this.mailString = mailString;
	}

	public String getAvarString() {
		return avarString;
	}

	public void setAvarString(String avarString) {
		this.avarString = avarString;
	}

	public String getRoleString() {
		return roleString;
	}

	public void setRoleString(String roleString) {
		this.roleString = roleString;
	}

	@Override
	public String toString() {
		return "Account [iDString=" + iDString + ", userNameString=" + userNameString + ", passwordString="
				+ passwordString + ", nameString=" + nameString + ", avString=" + avString + ", mailString="
				+ mailString + ", avarString=" + avarString + ", roleString=" + roleString + "]";
	}
	
	
	
	
	
	

}
