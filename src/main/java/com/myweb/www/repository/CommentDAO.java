package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.CommentVO;

public interface CommentDAO {

	int insert(CommentVO cvo);

	List<CommentVO> selectList(int bno);

}
