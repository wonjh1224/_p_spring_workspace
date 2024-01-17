package com.myweb.www.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.PaginVO;
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

	@GetMapping("register")
	public void register() {

	}

	@PostMapping("register")
	public String register(BoardVO bvo) {
		log.info(" @@ bvo > {}", bvo);
	
		long bno = bsv.register(bvo);
		
		return "redirect:/board/detail/"+bno;
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
		
		BoardVO bvo = bsv.detail(bno);

		m.addAttribute("bvo", bvo);

		isReadCount = true;

		return "/board/detail";

	}

	@GetMapping("modify/{bno}")
	public String modify(@PathVariable int bno, Model m) {
		BoardVO bvo = bsv.detail(bno);

		m.addAttribute("bvo", bvo);

		return "/board/modify";
	}

	@PostMapping("modify")
	public String modify(BoardVO bvo, RedirectAttributes re) {
		isReadCount = false;

		log.info("@@ bvo >> {}", bvo);

		int isMod = bsv.modify(bvo);

		re.addFlashAttribute("isMod", isMod);

		return "redirect:/board/detail/" + bvo.getBno();
	}

	@GetMapping("remove/{bno}")
	public String remove(@PathVariable int bno, RedirectAttributes re) {
		int isDel = bsv.remove(bno);
		
		re.addFlashAttribute("isDel", isDel);
		
		return "redirect:/board/list";
	}

}
