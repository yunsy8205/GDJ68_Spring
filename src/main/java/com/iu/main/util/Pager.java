package com.iu.main.util;


public class Pager {

	private Long startRow;
	private Long lastRow;
	
	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	private Long page;
	//한페이지에 보여질 데이터(row)의 갯수
	private Long perPage;
	
	//시작번호
	private Long startNum;
	//끝번호
	private Long lastNum;
	
	public boolean isPre() {
		return pre;//getter
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;//getter
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	//이전블럭활성화
	private boolean pre; //false면 1번블럭, true면 1번 아님
	//다음블럭 활성화
	private boolean next; //false면 마지막블럭, true 마지막 블럭 아님
	
	public void makePageNum(Long total) {
		//130 -> 13
		//131-139 -> 14
		
		//1.전체 갯수로 전체 페이지 수 구하기
		this.totalPage=total/this.getPerPage();//0으로 나누어지는 것 방지
		if(total%this.getPerPage()!=0) {
			this.totalPage++;
		}
		
		//2. 전체 페이지수로 전체 block 수 구하기
		// 한 페이지에 출력할 번호의 갯수
		long perBlock=5;
		
		long totalBlock = this.totalPage/perBlock;
		if(this.totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		//3. 현재 page 번호로 블럭번호 구하기
		// 현재 블럭 번호
		long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock !=0) {
			curBlock++;
		}
		
		//4. 현재 블럭번호의 시작번호와 끝 번호 구하기
		//curBlock     startNum    lastNum
		//1             1           5
		//2             6           10
		this.startNum=(curBlock-1)*perBlock+1;
		this.lastNum=curBlock*perBlock;
	
		//이전 블럭의 활성화 여부
		if(curBlock>1) {
			this.pre=true;
		}
		//다음 블럭 활성화 여부
		if(curBlock<totalBlock) {
			this.next=true;
		}
		
		//현재 블럭이 마지막 블럭일때 lastNum을 totalpage숫자로 대입
		//if(curBlock==totalBlock) {
		if(!this.next) {
			this.lastNum=totalPage;
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
