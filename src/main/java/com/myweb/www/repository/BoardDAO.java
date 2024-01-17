package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PaginVO;

public interface BoardDAO {

	void insert(BoardVO bvo);

	List<BoardVO> selectAll();

	BoardVO selectOne(int bno);

	void update(long bno);

	int update(BoardVO bvo);

	int updateReadCount(int bno);

	int delete(int bno);

	long getBno();

	int selectCount(PaginVO pgvo);



}
