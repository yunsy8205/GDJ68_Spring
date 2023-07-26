package com.iu.main.util;


public class Pager {

	private Long startRow;
	private Long lastRow;
	
	
	private Long page;
	//한페이지에 보여질 데이터(row)의 갯수
	private Long perPage;
	
	public void makePageNum(Long total) {
		//130 -> 13
		//131-139 -> 14
		this.totalPage=total/this.getPerPage();//0으로 나누어지는 것 방지
		if(total%this.getPerPage()!=0) {
			this.totalPage++;
		}
	}
	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	//총 페이지의 갯수
	private Long totalPage;
	
	
	public void makeRowNum() {
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
		// null인 경우를 대비해서 get메서드 호출
		this.lastRow=page*perPage;// 밑에는 위에서 변경된 값이 저장되어서 안바꿔도 됨
		
	}
	
	public Long getPage() {
		if(this.page==null) {
			this.page=1L;
		}
		// 페이지 값이 없을 경우 디폴트를 1로 넣는다.
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}		// 페이지 값이 없을 경우 디폴트를 1로 넣는다.
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

}
