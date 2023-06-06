package com.webservice.IeltsWeb;


import java.time.LocalDateTime;

public class ErrorDetail {
	private LocalDateTime localDate;
	private String messageString;
	private String detail;
	
	public ErrorDetail(LocalDateTime localDateTime, String messageString, String detail) {
		super();
		this.localDate = localDateTime;
		this.messageString = messageString;
		this.detail = detail;
	}


	
	public LocalDateTime getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDateTime localDate) {
		this.localDate = localDate;
	}

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	

}
