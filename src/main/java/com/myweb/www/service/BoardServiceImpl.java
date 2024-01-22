package com.myweb.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PaginVO;
import com.myweb.www.repository.BoardDAO;
import com.myweb.www.repository.FileDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

	private final BoardDAO bdao;
	
	private final FileDAO fdao;

	@Transactional
	@Override
	public int register(BoardDTO bdto) {
		
		int isOk = bdao.insert(bdto.getBvo());
		if(bdto.getFlist() == null) {
			return isOk;
		}
		
		//파일도 있다면
		if(isOk > 0 && bdto.getFlist().size() > 0) {
			// bno setting 
			long bno = bdao.getBno(); // 가장 마지막에 등록된 bno
			for(FileVO fvo : bdto.getFlist()) {
				fvo.setBno(bno);
				isOk *= fdao.insertFile(fvo);
			}
		}
		
		return isOk;
		
	}

	@Override
	public List<BoardVO> getList(PaginVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.selectList(pgvo);
	}

	@Transactional
	@Override
	public BoardDTO detail(int bno) {
		BoardVO bvo = bdao.selectOne(bno);
		List<FileVO> flist = fdao.getFileList(bno);
		BoardDTO bdto =  new BoardDTO(bvo, flist);
		return bdto;
	}

	@Transactional
	@Override
	public int modify(BoardDTO bdto) {
		// TODO Auto-generated method stub
		int isOk = bdao.update(bdto.getBvo());
		if(bdto.getFlist()==null) {
			return isOk;			
		}
		//bvo insert후 파일도 있다면
		if(isOk > 0 && bdto.getFlist().size() > 0) {
			long bno = bdao.getBno();
			for(FileVO fvo : bdto.getFlist()) {
				fvo.setBno(bdto.getBvo().getBno());
				isOk *= fdao.insertFile(fvo);
			}
		}
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

	@Override
	public long getBno() {
		return bdao.getBno();
	}

	@Override
	public int removeFile(String uuid) {
		// TODO Auto-generated method stub
		return fdao.deleteFile(uuid);
	}







}
