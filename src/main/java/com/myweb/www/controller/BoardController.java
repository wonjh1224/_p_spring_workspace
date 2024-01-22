package com.myweb.www.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PaginVO;
import com.myweb.www.handler.FileHandler;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
@Controller
public class BoardController {

	private final BoardService bsv;
	private boolean isReadCount = true;
	private final FileHandler fh;

	@GetMapping("register")
	public void register() {

	}

	@PostMapping("register")
	public String register(BoardVO bvo, RedirectAttributes re,
			@RequestParam(name = "files", required = false) MultipartFile[] files) {
		log.info(" @@ bvo > {}", bvo);
		// 파일 업로드
		List<FileVO> flist = null;

		// fileHandler 생성 mutilpartFile -> flist
		if (files[0].getSize() > 0) {
			flist = fh.uploadFiles(files);
		}

		int isOk = bsv.register(new BoardDTO(bvo, flist));
		re.addFlashAttribute("isOk", isOk);

		long bno = bsv.getBno();

		return "redirect:/board/detail/" + bno;
	}

	@GetMapping("list")
	public String list(Model m, PaginVO pgvo) {
		List<BoardVO> list = bsv.getList(pgvo);

		int totalCount = bsv.getTotalCount(pgvo);

		PagingHandler ph = new PagingHandler(pgvo, totalCount);

		m.addAttribute("list", list);
		m.addAttribute("ph", ph);

		return "/board/list";
	}

	@GetMapping("detail/{bno}")
	public String detail(@PathVariable int bno, Model m) {
		log.info("@@ bno > {}", bno);

		if (isReadCount) {
			bsv.updateReadCount(bno);
		}

		BoardDTO bdto = bsv.detail(bno);

		m.addAttribute("bdto", bdto);

		isReadCount = true;

		return "/board/detail";

	}

	@GetMapping("modify/{bno}")
	public String modify(@PathVariable int bno, Model m) {
		BoardDTO bdto = bsv.detail(bno);

		m.addAttribute("bdto", bdto);

		return "/board/modify";
	}

	@PostMapping("modify")
	public String modify(BoardVO bvo, RedirectAttributes re,
			@RequestParam(name="files", required = false)MultipartFile[] files) {
		
		isReadCount = false;

		log.info("@@ bvo >> {}", bvo);
		
		List<FileVO> flist = null;
		
		if(files[0].getSize() > 0) {
			flist = fh.uploadFiles(files);
		}

		int isMod = bsv.modify(new BoardDTO(bvo, flist));

		re.addFlashAttribute("isMod", isMod);

		return "redirect:/board/detail/" + bvo.getBno();
	}

	@GetMapping("remove/{bno}")
	public String remove(@PathVariable int bno, RedirectAttributes re) {
		int isDel = bsv.remove(bno);

		re.addFlashAttribute("isDel", isDel);

		return "redirect:/board/list";
	}

	@DeleteMapping("/{uuid}")
	@ResponseBody
	public String removeFile(@PathVariable String uuid) {
		int isFileDel = bsv.removeFile(uuid);
		
		return isFileDel > 0 ? "1" : "0";
	}
	
}
