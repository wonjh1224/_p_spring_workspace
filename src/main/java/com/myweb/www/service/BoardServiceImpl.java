package com.myweb.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PaginVO;
import com.myweb.www.repository.BoardDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

	private final BoardDAO bdao;

	@Transactional
	@Override
	public long register(BoardVO bvo) {
		bdao.insert(bvo);
		return bdao.getBno();
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return bdao.selectAll();
	}

	@Override
	public BoardVO detail(int bno) {
		// TODO Auto-generated method stub
		return bdao.selectOne(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		// TODO Auto-generated method stub
		int isOk = bdao.update(bvo);
		return isOk;
		
	}

	@Override
	public int updateReadCount(int bno) {
		// TODO Auto-generated method stub
		return bdao.updateReadCount(bno);
	}

	@Override
	public int remove(int bno) {
		// TODO Auto-generated method stub
		return bdao.delete(bno);
	}

	@Override
	public int getTotalCount(PaginVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.selectCount(pgvo);
	}





}
