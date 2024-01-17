package com.myweb.www.handler;

import java.util.List;

import com.myweb.www.domain.PaginVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class PagingHandler {

	private int startPage; //페이지네이션 시작번호 1, 11, 21
	private int endPage; // 끝번호 10, 20, 30
	private boolean prev, next;
	
	private int totalCount;
	private PaginVO pgvo;
	
	public PagingHandler(PaginVO pgvo, int totalCount) {
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		
		endPage = (int)Math.ceil(pgvo.getPageNo()/(double)pgvo.getQty())*10;
		startPage = endPage - 9;
		int RealEndPage = (int)Math.ceil(totalCount/(double)pgvo.getQty()); 
		
		if(RealEndPage < endPage) {
			endPage = RealEndPage;
		}
		
		prev = startPage>1;
		next = endPage<RealEndPage;
		
	}
	
	
	
	
	
	
	
	
	
}
