package com.myweb.www.service;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.repository.CommentDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService{

	private final CommentDAO cdao;

	@Override
	public int register(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.insert(cvo);
	}
	
}
