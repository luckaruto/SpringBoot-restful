package com.webservice.IeltsWeb.Model;

import java.sql.Date;

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
public class Comment {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	 private String CMTID;
	
	
	@Column(name = "forum_id")
	 private String FID;
	 
	@Column(name = "account_id")
	 private String ID;
	 
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "account_id", insertable = false, updatable = false)
	 @JsonIgnore
	 private Account iDAccount;
	 
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "forum_id", insertable = false, updatable = false)
	 @JsonIgnore
	 private Forum forumID;
	 
	  
	 private String CONTENT;
	 
	 private Date  DaDatCMT_TIME;
	 
	 
	public Comment() {};
	 

	public Comment(String cMTID, String fID, String iD, Account iDAccount, Forum forumID, String cONTENT,
			Date daDatCMT_TIME) {
		super();
		CMTID = cMTID;
		FID = fID;
		ID = iD;
		this.iDAccount = iDAccount;
		this.forumID = forumID;
		CONTENT = cONTENT;
		DaDatCMT_TIME = daDatCMT_TIME;
	}

	public String getCMTID() {
		return CMTID;
	}

	public void setCMTID(String cMTID) {
		CMTID = cMTID;
	}

	public String getFID() {
		return FID;
	}

	public void setFID(String fID) {
		FID = fID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Account getiDAccount() {
		return iDAccount;
	}

	public void setiDAccount(Account iDAccount) {
		this.iDAccount = iDAccount;
	}

	public Forum getForumID() {
		return forumID;
	}

	public void setForumID(Forum forumID) {
		this.forumID = forumID;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public Date getDaDatCMT_TIME() {
		return DaDatCMT_TIME;
	}

	public void setDaDatCMT_TIME(Date daDatCMT_TIME) {
		DaDatCMT_TIME = daDatCMT_TIME;
	}


	@Override
	public String toString() {
		return "Comment [CMTID=" + CMTID + ", FID=" + FID + ", ID=" + ID + ", iDAccount=" + iDAccount + ", forumID="
				+ forumID + ", CONTENT=" + CONTENT + ", DaDatCMT_TIME=" + DaDatCMT_TIME + "]";
	}
	 
	 
	 
	 

}
