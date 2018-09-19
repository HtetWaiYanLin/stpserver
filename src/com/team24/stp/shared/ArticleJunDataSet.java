package com.team24.stp.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ArticleJunDataSet {
	
	private ArticleJunData[] data;
	private String[] crop;
	private String[] agro;
	private String[] fer;
	private String[] town;
	private int totalCount;
	private int currentPage;
	private int pageSize;
	private boolean state;
	public ArticleJunData[] getData() {
		return data;
	}
	public void setData(ArticleJunData[] data) {
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
	public String[] getCrop() {
		return crop;
	}
	public void setCrop(String[] crop) {
		this.crop = crop;
	}
	public String[] getAgro() {
		return agro;
	}
	public void setAgro(String[] agro) {
		this.agro = agro;
	}
	public String[] getFer() {
		return fer;
	}
	public void setFer(String[] fer) {
		this.fer = fer;
	}
	public String[] getTown() {
		return town;
	}
	public void setTown(String[] town) {
		this.town = town;
	}
	

}
