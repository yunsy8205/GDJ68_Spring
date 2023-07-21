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
	public Integer getStudTotal() {
		return studTotal;
	}
	public void setStudTotal(Integer studTotal) {
		this.studTotal = studTotal;
	}
	public Double getStudAvg() {
		return studAvg;
	}
	public void setStudAvg(Double studAvg) {
		this.studAvg = studAvg;
	}
	
	private Integer studTotal;
	private Double studAvg;

}
