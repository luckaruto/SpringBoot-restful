package com.webservice.IeltsWeb.Model;

import java.sql.Date;
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


@Entity
public class Forum {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String FID;
	
	
	@Column(name = "account_id")
	private String IDuser;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", insertable = false, updatable = false)
	@JsonIgnore
	private Account ID;
	
	private String TITLE;       
	
	private Date DATE_ESTABLISHED;
	
	private String CONTENT;
	
	private String IMG;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "forumID")
	private Set<Comment> listComment;
	
   public Forum() {}
   
   
   


	public Set<Comment> getListComment() {
	return listComment;
}





public void setListComment(Set<Comment> listComment) {
	this.listComment = listComment;
}





	public Forum(String fID, String iDuser, Account iD, String tITLE, Date dATE_ESTABLISHED, String cONTENT, String iMG) {
		super();
		FID = fID;
		IDuser = iDuser;
		ID = iD;
		TITLE = tITLE;
		DATE_ESTABLISHED = dATE_ESTABLISHED;
		CONTENT = cONTENT;
		IMG = iMG;
	}


	public String getFID() {
		return FID;
	}
	
	
	public void setFID(String fID) {
		FID = fID;
	}
	
	
	public String getIDuser() {
		return IDuser;
	}
	
	
	public void setIDuser(String iDuser) {
		IDuser = iDuser;
	}
	
	
	public Account getID() {
		return ID;
	}
	
	
	@JsonIgnore
	public void setID(Account iD) {
		ID = iD;
	}
	
	
	public String getTITLE() {
		return TITLE;
	}
	
	
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	
	
	public Date getDATE_ESTABLISHED() {
		return DATE_ESTABLISHED;
	}
	
	
	public void setDATE_ESTABLISHED(Date dATE_ESTABLISHED) {
		DATE_ESTABLISHED = dATE_ESTABLISHED;
	}
	
	
	public String getCONTENT() {
		return CONTENT;
	}
	
	
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	
	
	public String getIMG() {
		return IMG;
	}
	
	
	public void setIMG(String iMG) {
		IMG = iMG;
	}
	
	
	@Override
	public String toString() {
		return "Forum [FID=" + FID + ", IDuser=" + IDuser + ", ID=" + ID + ", TITLE=" + TITLE + ", DATE_ESTABLISHED="
		+ DATE_ESTABLISHED + ", CONTENT=" + CONTENT + ", IMG=" + IMG + "]";
	};
		

   

	  			
	
	   
	

}
