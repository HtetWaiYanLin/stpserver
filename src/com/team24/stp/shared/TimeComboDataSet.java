package com.team24.stp.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TimeComboDataSet {
	
	private TimeComboData[] data;
	
	public TimeComboDataSet(){
		data = new TimeComboData[0];
	}
	
	public TimeComboData[] getData() {
		return data;
	}

	public void setData(TimeComboData[] data) {
		this.data = data;
	}
	
}
