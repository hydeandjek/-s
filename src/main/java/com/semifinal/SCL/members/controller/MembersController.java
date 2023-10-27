package com.semifinal.SCL.members.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semifinal.SCL.members.dto.MembersRequsetDTO;
import com.semifinal.SCL.members.entity.Members;
import com.semifinal.SCL.members.service.MembersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MembersController {

	private final MembersService service;
	
	//회원가입 페이지 이동
	@GetMapping("/memberJoin")
	public void userJoin() {}
	
	//아이디 중복 확인
	@GetMapping("/id/{account}")
	@ResponseBody
	public String idCheck(@PathVariable String account) {
		log.info("받은 계정 : {}",account);
		int result = service.idCheck(account);
		if(result == 1) return "duplicated";
		else return "ok";
	}
	
	//회원가입
	@PostMapping("/join")
	public void join(MembersRequsetDTO dto) {
		service.join(dto);
	}
	
	//로그인 페이지로 이동 요청
	@GetMapping("/memberLogin")
	public void login() {}
	
	//로그인 요청
	@PostMapping("/userLogin")
	public void login(String id, String pw, Model model) {
		model.addAttribute("result",service.login(id, pw));
	}
	
	@GetMapping("/memberMypage")
	public void userMypage(HttpSession session,Model model) {
		String memberId = (String) session.getAttribute("login");
		model.addAttribute("userInfo",service.getInfo(memberId));
	}
	
	
}
