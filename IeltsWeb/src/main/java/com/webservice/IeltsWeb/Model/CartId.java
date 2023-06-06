package com.webservice.IeltsWeb.Model;

import java.io.Serializable;


public class CartId implements Serializable  {
    
	 private String userId;
		
	 private String courseId;
    
    
    
	public String getId() {
		return userId;
	}
	public void setId(String id) {
		userId = id;
	}
	public String getCId() {
		return courseId;
	}
	public void setCId(String cId) {
		courseId = cId;
	}
	
	public CartId() {};
	public CartId(String id, String cId) {
		super();
		userId = id;
		courseId = cId;
	}
	    
    
	
	

}
