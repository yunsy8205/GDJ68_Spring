package com.iu.main.notice;

import java.sql.Date;
import java.util.List;

public class NoticeDTO {
	
	private Long num;
	private String title;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String writer;
	private String id;
	private List<NoticeFileDTO> fileDTOs;
	
	public Long getNum() {
		return num;
	}
	public List<NoticeFileDTO> getFileDTOs() {
		return fileDTOs;
	}
	public void setFileDTOs(List<NoticeFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	private Date createDate;
	private Integer hit;
	private String contents;

}
