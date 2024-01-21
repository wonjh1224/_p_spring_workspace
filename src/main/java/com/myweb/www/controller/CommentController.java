package com.myweb.www.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment/*")
public class CommentController {

	private final CommentService csv;
	
	@PostMapping("/post")
	@ResponseBody
	public String register(@RequestBody CommentVO cvo) {
		log.info("@@ cvo > {}", cvo);
		
		int isReg = csv.register(cvo);
		
		return isReg > 0 ? "1" : "0";
	}
	
	@GetMapping(value="/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CommentVO> list(@PathVariable int bno){
		List<CommentVO> list = csv.getList(bno);
		
		log.info("@@list >> {}", list);
		
		return list;
	}
	
	@PostMapping("/update")
	@ResponseBody
	public String update(@RequestBody CommentVO cvo) {
		log.info("@@ update cvo > {}", cvo);
		
		int isUpdate = csv.modify(cvo);
		
		return isUpdate > 0 ? "1" : "0";
		
	}
	
	@DeleteMapping("/{cno}")
	@ResponseBody
	public String delete(@PathVariable int cno) {
		log.info("@@ delete cno > ", cno);
		
		int isDel = csv.remove(cno);
		
		return isDel > 0 ? "1" : "0";
	}
}
