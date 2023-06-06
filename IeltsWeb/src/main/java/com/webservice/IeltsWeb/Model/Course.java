package com.webservice.IeltsWeb.Model;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;


@Entity
public class Course {
	

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	 private String CID;
	 
	 @Size(min=2,message = "Name must have from 2 words")
	 private String Name;
	 
	 private String Category;
	 
	 
	 @JsonIgnore
	 private String Description;
	 
	 
     @JsonIgnore
	 private float Price;
	 
     @JsonIgnore
	 private String Img;
	 
     
     @Column(name = " owner_idstring")  
	 private String ownerID;
     
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JsonIgnore
	 @JoinColumn(name = "owner_idstring", insertable = false, updatable = false)
	 private Account Owner;
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "courseId")
	 private Set<Lesson> listLessons;
	 

	 private float rating;
	 
	public Course() {};
	
	public Course(String cID, @Size(min = 2, message = "Name must have from 2 words") String name, String category,
			String description, float price, String img, String ownerID, Account owner, Set<Lesson> listLessons,
			float rating) {
		super();
		CID = cID;
		Name = name;
		Category = category;
		Description = description;
		Price = price;
		Img = img;
		this.ownerID = ownerID;
		Owner = owner;
		this.listLessons = listLessons;
		this.rating = rating;
	}
	

	public String getCID() {
		return CID;
	}


	public void setCID(String cID) {
		CID = cID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public float getPrice() {
		return Price;
	}


	public void setPrice(float price) {
		Price = price;
	}


	public String getImg() {
		return Img;
	}


	public void setImg(String img) {
		Img = img;
	}


	public String getOwnerID() {
		return ownerID;
	}


	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}


	public Set<Lesson> getListLessons() {
		return listLessons;
	}


	public void setListLessons(Set<Lesson> listLessons) {
		this.listLessons = listLessons;
	}


	public Account getOwner() {
		return Owner;
	}
	
	 @JsonIgnore
	public void setOwner(Account owner) {
		Owner = owner;
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Course [CID=" + CID + ", Name=" + Name + ", Category=" + Category + ", Description=" + Description
				+ ", Price=" + Price + ", Img=" + Img  + ", rating=" + rating + "]";
	}
	
	
	
	

 

}
