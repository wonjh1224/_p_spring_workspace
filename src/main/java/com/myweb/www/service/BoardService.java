package com.myweb.www.service;



import java.util.List;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PaginVO;

public interface BoardService {

	long register(BoardVO bvo);

	List<BoardVO> getList(PaginVO pgvo);

	BoardVO detail(int bno);

	int modify(BoardVO bvo);

	int updateReadCount(int bno);

	int remove(int bno);

	int getTotalCount(PaginVO pgvo);






}
