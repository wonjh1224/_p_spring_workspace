package com.myweb.www.service;



import java.util.List;

import com.myweb.www.domain.BoardVO;

public interface BoardService {

	long register(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO detail(int bno);

	int modify(BoardVO bvo);

	int updateReadCount(int bno);

	int remove(int bno);






}
