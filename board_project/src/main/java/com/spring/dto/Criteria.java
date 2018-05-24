package com.spring.dto;

public class Criteria {
	private int page; // page 번호
	private int perPageNum; //page 당 보여주는 row 개수
	
	public Criteria(){
		this.page=1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0){
			this.page=1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0 || perPageNum>20){
			this.perPageNum = 10;
			return;
		}
	
		this.perPageNum = perPageNum;
	}
	
	
	public int getPageStart(){
		return(this.page-1) * this.perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}
