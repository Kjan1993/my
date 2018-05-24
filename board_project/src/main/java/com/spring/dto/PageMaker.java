package com.spring.dto;

public class PageMaker {
	
	private int totalCount; //전체 board 개수
	private int startPage; //시작 페이지 번호
	private int endPage; //마지막 페이지 번호
	private boolean prev;// 이전 버튼 유무
	private boolean next;// 다음 버튼 유무
	
	private int displayPageNum = 10; //page 번호 개수
	
	private Criteria cri; // page번호, page당 보여주는 row개수

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	private void calcData(){
		endPage=(int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);
		startPage = (endPage-displayPageNum)+1;
		
		int tempEndPage=(int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		if(endPage>tempEndPage){
			endPage=tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage*cri.getPerPageNum() > totalCount ? false : true;
		
	}
	
	
}
