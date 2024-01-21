package com.myweb.www.service;



import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PaginVO;

public interface BoardService {

	int register(BoardDTO boardDTO);

	List<BoardVO> getList(PaginVO pgvo);

	BoardDTO detail(int bno);

	int modify(BoardVO bvo);

	int updateReadCount(int bno);

	int remove(int bno);

	int getTotalCount(PaginVO pgvo);

	long getBno();








}
