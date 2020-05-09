package com.neeraj.UserNotesSpringBootApp.Exception;

import java.util.Date;

public class CustomErrorDetail 
{
	private Date timestamp;
	private String error;
	private String errorDetail;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getErrorDetail() {
		return errorDetail;
	}
	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
	@Override
	public String toString() {
		return "CustomErrorDetail [timestamp=" + timestamp + ", error=" + error + ", errorDetail=" + errorDetail + "]";
	}
	
	
	

}
