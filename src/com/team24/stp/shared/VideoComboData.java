package com.team24.stp.shared;

public class VideoComboData {
	private String id;
	private String name;
	private boolean flag;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public void clearProperties() {
		this.id = "";
		this.name= "";
		this.flag=false;
	}
}
