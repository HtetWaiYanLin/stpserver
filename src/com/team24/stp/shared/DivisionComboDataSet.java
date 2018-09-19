package com.team24.stp.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DivisionComboDataSet {
	
private  DivisionComboData[] data;
	
	public  DivisionComboDataSet(){
		data = new  DivisionComboData[0];
	}

	public  DivisionComboData[] getData() {
		return data;
	}

	public void setData( DivisionComboData[] data) {
		this.data = data;
	}

}
