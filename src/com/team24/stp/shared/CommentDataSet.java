package com.team24.stp.shared;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CommentDataSet {
	private CommentData[] data;

	public CommentData[] getData() {
		return data;
	}

	public void setData(CommentData[] data) {
		this.data = data;
	}
	public CommentDataSet(){
		data = new CommentData[0];
	}

}
