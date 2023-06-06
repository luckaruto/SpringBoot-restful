package com.webservice.IeltsWeb.Model;

import java.sql.Time;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lesson {

   @Id
   @GeneratedValue(generator = "system-uuid")
   @GenericGenerator(name = "system-uuid", strategy = "uuid")
   private String LID;
   
   @Column(name = "course_id")
   private String CID;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	@JsonIgnore
	private Course courseId;
   
   private String NAME;            
   private String CONTENT;    
   
   private String VIDEO;
   
   
   private String ATTACHMENT;          
   private Time DURATION;
   
   public Lesson() {};

	public Lesson(String lID, String cID, Course courseId, String nAME, String cONTENT, String vIDEO, String aTTACHMENT,
			Time dURATION) {
		super();
		LID = lID;
		CID = cID;
		this.courseId = courseId;
		NAME = nAME;
		CONTENT = cONTENT;
		VIDEO = vIDEO;
		ATTACHMENT = aTTACHMENT;
		DURATION = dURATION;
	}
	
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	
	
	public String getVIDEO() {
		return VIDEO;
	}
	
	public void setVIDEO(String vIDEO) {
		VIDEO = vIDEO;
	}

	public String getLID() {
		return LID;
	}
	public void setLID(String lID) {
		LID = lID;
	}
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	
	
		
	public Course getCourseId() {
		return courseId;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getATTACHMENT() {
		return ATTACHMENT;
	}
	public void setATTACHMENT(String aTTACHMENT) {
		ATTACHMENT = aTTACHMENT;
	}
	public Time getDURATION() {
		return DURATION;
	}
	public void setDURATION(Time dURATION) {
		DURATION = dURATION;
	}            
	   
	
	   
	   
	
}
