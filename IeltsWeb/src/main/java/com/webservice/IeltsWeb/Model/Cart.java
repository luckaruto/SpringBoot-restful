package com.webservice.IeltsWeb.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;



@Entity
@IdClass(CartId.class)
public class Cart {	
	
	@Id
	@Column(name = "userid")
    private String userId;
	
	@Id
	@Column(name = "courseid")
    private String courseId;
	
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "courseid", insertable = false, updatable = false)
	private Course CID;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	private Account user;
	
	private boolean Status;
	
	private float Rating;
	
	public Cart() {}
	
	

	public Cart(String userId, String courseId, Course cID, Account user, boolean status, float rating) {
		super();
		this.userId = userId;
		this.courseId = courseId;
		CID = cID;
		this.user = user;
		Status = status;
		Rating = rating;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Course getCID() {
		return CID;
	}

	@JsonIgnore
	public void setCID(Course cID) {
		CID = cID;
	}

	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public float getRating() {
		return Rating;
	}

	public void setRating(float rating) {
		Rating = rating;
	}



	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", courseId=" + courseId + ", CID=" + CID + ", user=" + user + ", Status="
				+ Status + ", Rating=" + Rating + "]";
	};
	
    
	
	
	
	
}
