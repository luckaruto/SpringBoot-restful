package com.webservice.IeltsWeb.Model;

public class CourseDTO {
	
	String CID;
	String COURESENAME;
	String CATEGORY;
    String DESCRIPTION;
    float PRICE;
    String IMG;
    String OWNERNAME;
	public CourseDTO(String cID, String cOURESENAME, String cATEGORY, String dESCRIPTION, float pRICE, String iMG,
			String oWNERNAME) {
		super();
		CID = cID;
		COURESENAME = cOURESENAME;
		CATEGORY = cATEGORY;
		DESCRIPTION = dESCRIPTION;
		PRICE = pRICE;
		IMG = iMG;
		OWNERNAME = oWNERNAME;
	}
	public CourseDTO() {};
	
	
	
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getCOURESENAME() {
		return COURESENAME;
	}
	public void setCOURESENAME(String cOURESENAME) {
		COURESENAME = cOURESENAME;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public float getPRICE() {
		return PRICE;
	}
	public void setPRICE(float pRICE) {
		PRICE = pRICE;
	}
	public String getIMG() {
		return IMG;
	}
	public void setIMG(String iMG) {
		IMG = iMG;
	}
	public String getOWNERNAME() {
		return OWNERNAME;
	}
	public void setOWNERNAME(String oWNERNAME) {
		OWNERNAME = oWNERNAME;
	}

    
	
	
	

}
