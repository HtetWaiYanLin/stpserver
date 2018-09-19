package com.team24.stp.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MenuOrderData {
	
	private ArticleData[] menu_arr;
	private String menu;
	private long menusk;
	
	public MenuOrderData() {
		clearProperties();
	}
	
	protected void clearProperties() {
		this.menu = "";
		this.menusk = 0L;
		this.menu_arr = new ArticleData[0];
	}

	public ArticleData[] getMenu_arr() {
		return menu_arr;
	}

	public void setMenu_arr(ArticleData[] menu_arr) {
		this.menu_arr = menu_arr;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public long getMenusk() {
		return menusk;
	}

	public void setMenusk(long menusk) {
		this.menusk = menusk;
	}
	
}
