package com.team24.stp.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentData {
	private String userId;
	private String userName;
	private long userSyskey;
	private String comment;
	private String  modifieddate;
	private String modifiedtime;
	
	public CommentData() {
		clearProperties();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserSyskey() {
		return userSyskey;
	}
	public void setUserSyskey(long userSyskey) {
		this.userSyskey = userSyskey;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	protected void clearProperties() {
		this.userId = "";
		this.userName = "";
		this.userSyskey = 0L;
		this.comment = "";
		this.modifieddate="";
		this.modifiedtime="";
		
	}
}
