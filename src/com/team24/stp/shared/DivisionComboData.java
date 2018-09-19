package com.team24.stp.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DivisionComboData {
	
	private String value;
	private String caption;
	private boolean flag;
	

	public DivisionComboData() {
		super();
		clearProperties();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void clearProperties() {
		this.value = "";
		this.caption = "";
		this.flag=false;
	}

}
