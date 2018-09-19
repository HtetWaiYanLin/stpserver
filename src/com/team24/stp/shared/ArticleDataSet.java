package com.team24.stp.shared;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArticleDataSet {
	private ArticleData[] data;
	private String[] ansData;
	private int totalCount;
	private int currentPage;
	private int pageSize;
	private boolean state;
	private String username;
	public ArticleDataSet(){
		data = new ArticleData[0];
	}

	public ArticleData[] getData() {
		return data;
	}

	public void setData(ArticleData[] data) {
		this.data = data;
	}

	public int getTotalCount() {
		return totalCount;   
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String[] getAnsData() {
		return ansData;
	}

	public void setAnsData(String[] ansData) {
		this.ansData = ansData;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ArticleDataSet [data=" + Arrays.toString(data) + ", ansData=" + Arrays.toString(ansData)
				+ ", totalCount=" + totalCount + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", state="
				+ state + " , username=" + username + "]";
	}
}
