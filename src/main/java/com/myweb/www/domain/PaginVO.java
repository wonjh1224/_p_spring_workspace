package com.myweb.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class PaginVO {
	
	private int pageNo; // 현재 페이지 번호
	private int qty; // 한 페이지당 표시될 게시물 개수
	
	private String type;
	private String keyword;
	
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
	
	//type의 값을 배열로 생성
	//복합 타입의 키워드일 경우 각자 검색해야하기 때문에 배열로 생성
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}
	
}
