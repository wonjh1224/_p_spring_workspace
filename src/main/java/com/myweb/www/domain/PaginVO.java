package com.myweb.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class PaginVO {
	
	private int pageNo; // 현재 페이지 번호
	private int qty; // 한 페이지당 표시될 게시물 개수
	
//	private String type;
//	private String keyword;
	
	//첫 시작 
	public PaginVO() {
		this.pageNo = 1;
		this.qty = 10;
	}
	
	//실 사용
	public PaginVO(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}
	
	public int getPageStart() {
		return (this.pageNo - 1) * qty;
	}
	
}
