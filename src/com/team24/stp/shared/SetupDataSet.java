package com.team24.stp.shared;

public class SetupDataSet {
	private SetupData[] arr;
	private int totalCount;
	private int currentPage;
	private int pageSize;	
	private boolean state;
	private MenuOrderData[] menu_arr;
	
	public MenuOrderData[] getMenu_arr() {
		return menu_arr;
	}
	public void setMenu_arr(MenuOrderData[] menu_arr) {
		this.menu_arr = menu_arr;
	}
	public SetupData[] getArr() {
		return arr;
	}
	public void setArr(SetupData[] arr) {
		this.arr = arr;
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
	

}
