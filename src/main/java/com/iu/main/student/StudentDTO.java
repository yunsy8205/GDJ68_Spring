package com.iu.main.student;

public class StudentDTO {
	
	private Long studNum;
	private String studName;
	private Integer studKor;
	private Integer studEng;
	private Integer studMath;
	
	public Long getStudNum() {
		return studNum;
	}
	public void setStudNum(Long studNum) {
		this.studNum = studNum;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public Integer getStudKor() {
		return studKor;
	}
	public void setStudKor(Integer studKor) {
		this.studKor = studKor;
	}
	public Integer getStudEng() {
		return studEng;
	}
	public void setStudEng(Integer studEng) {
		this.studEng = studEng;
	}
	public Integer getStudMath() {
		return studMath;
	}
	public void setStudMath(Integer studMath) {
		this.studMath = studMath;
	}

	public void setStudTotal(Integer total) {
		this.studTotal = total;
	}
	public void setStudAvg(Double avg) {
		this.studAvg = avg;
	}
	
	public void setStudTotal() {
		this.studTotal = studKor+studEng+studMath;

	}
	public void setStudAvg() {
		this.studAvg = ((int)studTotal)/3.0;
	}
	
	public Integer getStudTotal() {
		return studTotal;
	}
	public Double getStudAvg() {
		return studAvg;
	}


	private Integer studTotal;
	private Double studAvg;

}
