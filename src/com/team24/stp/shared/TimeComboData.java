package com.team24.stp.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TimeComboData {

	private String value;
	private String key;
	private String caption;
	
	public TimeComboData() {
		super();
		clearProperties();
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public void clearProperties() {
		this.value = "";
		this.key="";
		this.caption = "";
	}
	
}
