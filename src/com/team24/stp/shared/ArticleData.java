package com.team24.stp.shared;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArticleData {
	private long syskey;
	private long autokey;
	private String createdDate;
	private String createdTime;
	private String modifiedDate;
	private String modifiedTime;
	private String alertTime;
	private String alertDate;
	private String userId;
	private String userName;
	private String modifiedUserId;
	private String modifiedUserName;
	private int recordStatus;
	private int syncStatus;
	private long syncBatch;
	private long userSyskey;
	private int serialno;
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	private String t6;
	private String t7;
	private String t8;
	private String t9;
	private String t10;
	private String t11;
	private String t12;
	private String t13;
	private String temp;
	private long n1;
	private long n2;
	private long n3;
	private long n4;
	private long n5;
	private long n6;
	private long n7;
	private long n8;
	private long n9;
	private long n10;
	private long n11;
	private long n12;
	private long n13;
	private String upload[];
	private String answer[];
	private String videoUpload[];
	private CommentData comData[];
	private String cropdata[];
	private String agrodata[];
	private String ferdata[];
	private String towndata[];
	private ArrayList<PhotoUploadData> uploadlist;
	private String resizelist[];
	private ArrayList<UploadData> uploadDatalist;
	private UploadData[] uploadedPhoto;

	public CommentData[] getComData() {
		return comData;
	}

	public void setComData(CommentData[] comData) {
		this.comData = comData;
	}

	public ArticleData() {
		super();
		clearProperties();
	}

	public long getSyskey() {
		return syskey;
	}

	public void setSyskey(long syskey) {
		this.syskey = syskey;
	}

	public long getAutokey() {
		return autokey;
	}

	public void setAutokey(long autokey) {
		this.autokey = autokey;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
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

	public int getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}

	public int getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(int syncStatus) {
		this.syncStatus = syncStatus;
	}

	public long getSyncBatch() {
		return syncBatch;
	}

	public void setSyncBatch(long syncBatch) {
		this.syncBatch = syncBatch;
	}

	public long getUserSyskey() {
		return userSyskey;
	}

	public void setUserSyskey(long userSyskey) {
		this.userSyskey = userSyskey;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getT3() {
		return t3;
	}

	public void setT3(String t3) {
		this.t3 = t3;
	}

	public String getT4() {
		return t4;
	}

	public void setT4(String t4) {
		this.t4 = t4;
	}

	public String getT5() {
		return t5;
	}

	public void setT5(String t5) {
		this.t5 = t5;
	}

	public String getT6() {
		return t6;
	}

	public void setT6(String t6) {
		this.t6 = t6;
	}

	public String getT7() {
		return t7;
	}

	public void setT7(String t7) {
		this.t7 = t7;
	}

	public String getT8() {
		return t8;
	}

	public void setT8(String t8) {
		this.t8 = t8;
	}

	public String getT9() {
		return t9;
	}

	public void setT9(String t9) {
		this.t9 = t9;
	}

	public String getT10() {
		return t10;
	}

	public void setT10(String t10) {
		this.t10 = t10;
	}

	public String getT11() {
		return t11;
	}

	public void setT11(String t11) {
		this.t11 = t11;
	}

	public String getT12() {
		return t12;
	}

	public void setT12(String t12) {
		this.t12 = t12;
	}

	public String getT13() {
		return t13;
	}

	public void setT13(String t13) {
		this.t13 = t13;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public long getN1() {
		return n1;
	}

	public void setN1(long n1) {
		this.n1 = n1;
	}

	public long getN2() {
		return n2;
	}

	public void setN2(long n2) {
		this.n2 = n2;
	}

	public long getN3() {
		return n3;
	}

	public void setN3(long n3) {
		this.n3 = n3;
	}

	public long getN4() {
		return n4;
	}

	public void setN4(long n4) {
		this.n4 = n4;
	}

	public long getN5() {
		return n5;
	}

	public void setN5(long n5) {
		this.n5 = n5;
	}

	public long getN6() {
		return n6;
	}

	public void setN6(long n6) {
		this.n6 = n6;
	}

	public long getN7() {
		return n7;
	}

	public void setN7(long n7) {
		this.n7 = n7;
	}

	public long getN8() {
		return n8;
	}

	public void setN8(long n8) {
		this.n8 = n8;
	}

	public long getN9() {
		return n9;
	}

	public void setN9(long n9) {
		this.n9 = n9;
	}

	public long getN10() {
		return n10;
	}

	public void setN10(long n10) {
		this.n10 = n10;
	}

	public long getN11() {
		return n11;
	}

	public void setN11(long n11) {
		this.n11 = n11;
	}

	public long getN12() {
		return n12;
	}

	public void setN12(long n12) {
		this.n12 = n12;
	}

	public long getN13() {
		return n13;
	}

	public void setN13(long n13) {
		this.n13 = n13;
	}

	public String[] getUpload() {
		return upload;
	}

	public void setUpload(String[] upload) {
		this.upload = upload;
	}

	public String[] getVideoUpload() {
		return videoUpload;
	}

	public void setVideoUpload(String[] videoUpload) {
		this.videoUpload = videoUpload;
	}


	public String[] getResizelist() {
		return resizelist;
	}

	public void setResizelist(String[] resizelist) {
		this.resizelist = resizelist;
	}

	public String[] getCropdata() {
		return cropdata;
	}

	public void setCropdata(String[] cropdata) {
		this.cropdata = cropdata;
	}

	public String[] getAgrodata() {
		return agrodata;
	}

	public void setAgrodata(String[] agrodata) {
		this.agrodata = agrodata;
	}

	public String[] getFerdata() {
		return ferdata;
	}

	public void setFerdata(String[] ferdata) {
		this.ferdata = ferdata;
	}

	public String[] getTowndata() {
		return towndata;
	}

	public void setTowndata(String[] towndata) {
		this.towndata = towndata;
	}

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public ArrayList<PhotoUploadData> getUploadlist() {
		return uploadlist;
	}

	public void setUploadlist(ArrayList<PhotoUploadData> uploadlist) {
		this.uploadlist = uploadlist;
	}

	public ArrayList<UploadData> getUploadDatalist() {
		return uploadDatalist;
	}

	public void setUploadDatalist(ArrayList<UploadData> uploadDatalist) {
		this.uploadDatalist = uploadDatalist;
	}

	public UploadData[] getUploadedPhoto() {
		return uploadedPhoto;
	}

	public void setUploadedPhoto(UploadData[] uploadedPhoto) {
		this.uploadedPhoto = uploadedPhoto;
	}
	
	public String getModifiedUserId() {
		return modifiedUserId;
	}

	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	public String getModifiedUserName() {
		return modifiedUserName;
	}

	public void setModifiedUserName(String modifiedUserName) {
		this.modifiedUserName = modifiedUserName;
	}

	public int getSerialno() {
		return serialno;
	}

	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}
	
	
	public String getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(String alertDate) {
		this.alertDate = alertDate;
	}

	public String getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(String alertTime) {
		this.alertTime = alertTime;
	}

	protected void clearProperties() {
		this.syskey = 0L;
		this.autokey = 0L;
		this.createdDate = "";
		this.createdTime = "";
		this.modifiedDate = "";
		this.modifiedTime = "";
		this.userId = "";
		this.userName = "";
		this.modifiedUserId = "";
		this.modifiedUserName = "";
		this.recordStatus = 0;
		this.syncStatus = 0;
		this.syncBatch = 0L;
		this.userSyskey = 0L;
		this.t1 = "";
		this.t2 = "";
		this.t3 = "";
		this.t4 = "";
		this.t5 = "";
		this.t6 = "";
		this.t7 = "";
		this.t8 = "";
		this.t9 = "";
		this.t10 = "";
		this.t11 = "";
		this.t12 = "";
		this.t13 = "";
		this.temp = "";
		this.n1 = 0;
		this.n2 = 0;
		this.n3 = 0;
		this.n4 = 0;
		this.n5 = 0;
		this.n6 = 0;
		this.n7 = 0;
		this.n8 = 0;
		this.n9 = 0;
		this.n10 = 0;
		this.n11 = 0;
		this.n12 = 0;
		this.n13 = 0;
		this.serialno = 0;
		this.upload = new String[0];
		this.answer = new String[0];
		this.videoUpload = new String[0];
		this.cropdata = new String[0];
		this.agrodata = new String[0];
		this.ferdata = new String[0];
		this.towndata = new String[0];
		comData = new CommentData[0];
		this.uploadlist = new ArrayList<>();
		this.uploadDatalist = new ArrayList<>();
		this.resizelist=new String[0];
		this.uploadedPhoto = new UploadData[0];
		this.alertDate = "";
		this.alertTime = "";
	}
	
}
