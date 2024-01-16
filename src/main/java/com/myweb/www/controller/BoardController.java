package com.myweb.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RequestMapping("/board/**")
@Slf4j
@Controller
public class BoardController {

	
	private final BoardService bsv;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	
}
