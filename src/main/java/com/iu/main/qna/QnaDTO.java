package com.iu.main.qna;

import java.sql.Date;

public class QnaDTO {
	
	private Long num;
	private String writer;
	private String title;
	private String contents;
	private Date createDate;
	private Integer hit;
	private Long ref;
	private Long step;
	private Long depth;
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
}
