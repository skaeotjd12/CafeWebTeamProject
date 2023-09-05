package com.green.cafe.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.cafe.dto.MemDto;
import com.green.cafe.service.MemService;

@Controller
@RequestMapping("/member")
public class MemController {

	@Autowired
	private MemService service;
	
	/**로그인정보를 세션에 넣을 수 있게 세션을 설정함*/
	private HttpSession session;
	
	/**로그인 페이지*/
	@RequestMapping("/login")
	public String login() {
		System.out.println("로그인 화면입니다. 아이디와 비밀번호를 입력하세요.");
		

		return "member/login";
	}
	/**로그아웃 - 세션제거*/
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		System.out.println("로그아웃합니다.");
        HttpSession session = request.getSession(false);
        if (session != null) {
        	System.out.println("세션에 보관된 정보를 제거합니다.");
            session.invalidate();
        }
        System.out.println("로그아웃이 완료되어 화면으로 이동합니다.");
        return "redirect:../post/list";
    } 
	/**로그인 처리 및 자동등업확인*/
	@RequestMapping("/loginYn") //로그인 처리
	public String loginYn(@RequestParam HashMap<String, String> param, Model model,HttpServletRequest request) {
		System.out.println("로그인을 합니다.");
		
		int re = service.loginYn(param);
		if(re==1) {
			System.out.println("아이디와 비밀번호 일치");
			service.countDays(); //가입일수체크
			ArrayList<MemDto> dtos = service.loginView(param);
			model.addAttribute("loginView",dtos);
			System.out.println("세션에 로그인정보를 저장합니다.");
			//세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
	        session = request.getSession(true);
	        //세션에 로그인 회원 정보 보관
	        // session.setAttribute(SessionConst.LOGIN_MEMBER, param);
	        session.setAttribute("mem_id", param.get("mem_id"));
	        session.setAttribute("mem_level", dtos.get(0).getMem_level());
	        
	        System.out.println("session >> " + session.getAttribute("mem_id"));
	        System.out.println("session >> " + session.getAttribute("mem_level"));
	        
			if(dtos.get(0).getMem_days() >= 7 && dtos.get(0).getMem_level() == 1) {
			//로그인할때 가입 후 경과일이 7일 이상시 lv.1에서 lv.2로 등급변경
				System.out.println("축하합니다. 가입 후 7일이 경과되어 자동으로 레벨이 올라갑니다.");
				service.levelUp_auto(param);
				dtos = service.loginView(param);
				model.addAttribute("loginView",dtos);
			}
			
			return "redirect:../post/list";
		}
		return "redirect:../post/list";
	}
	
	/**회원가입 페이지*/
	@RequestMapping("/register")
	public String register() {
		System.out.println("회원가입페이지입니다. 회원가입 후 로그인해주세요");
		
		return "member/register";
	}
	
	/**회원가입 처리*/
	@RequestMapping("/registerOk")
	public String registerOk(@RequestParam HashMap<String, String> param, Model model) {
		service.register(param);
		
		System.out.println("회원등록완료->로그인 페이지로 이동됩니다.");
		return "member/login";
	}
	/**정보수정 페이지*/
	@RequestMapping("/updateInfo") //회원정보 수정 폼
	public String updateInfo(@RequestParam HashMap<String, String> param,Model model) {
		System.out.println("정보를 수정할 수 있습니다.");
		ArrayList<MemDto> dtos = service.loginView(param);
		model.addAttribute("loginView",dtos);//회원아이디로 전체 정보를 조회하기 위해 넘김
		return "member/updateInfo";
	}
	/**변경된 정보 테이블 업데이트 처리*/
	@RequestMapping("/updateInfoOk") //회원정보 수정 처리 update -> MemServiceImpl.java
	public String updateInfoOk(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("회원님의 정보를 수정합니다.");
		service.updateInfo(param);
		System.out.println("회원정보 수정완료");
		ArrayList<MemDto> dtos = service.loginView(param);
		model.addAttribute("loginView",dtos);
		System.out.println("회원정보페이지로 이동합니다.");
		return "member/checkInfo";//정보 수정 후 checkInfo로 이동
	}
	/**회원 : 개인정보 페이지*/
	@RequestMapping("/checkInfo") 
	public String checkInfo(@RequestParam HashMap<String, String> param,Model model) {
		System.out.println("회원정보 페이지입니다. 정보를 확인하세요.");
		
		ArrayList<MemDto> dtos = service.loginView(param);
		model.addAttribute("loginView",dtos);//회원아이디로 전체 정보를 조회하기 위해 넘김
		
		return "member/checkInfo";
	}
	/**관리자 : 회원조회 페이지*/
	@RequestMapping("/memberView")
	public String memberView(Model model) {
		System.out.println("회원관리 페이지입니다.");
		service.countDays();
		ArrayList<MemDto> dtos = service.memberView();
		model.addAttribute("MemberView",dtos);
		
		return "member/memberView";
	}
	
	/**회원탈퇴*/
	@RequestMapping("/deleteMember") //회원탈퇴
	public String deleteMember(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("회원탈퇴를 시작합니다.");
		service.deleteMember(param);
		System.out.println("회원탈퇴완료");
		
		param = (HashMap<String, String>) session.getAttribute(SessionConst.LOGIN_MEMBER);
		//관리자의 회원관리 페이지에서 강퇴를 시킨 경우 memberView로 이동하도록 로그인정보를 세션으로부터 받아옴
		if(param.get("mem_id").equals("admin")) { 
			System.out.println("관리자님 회원관리 페이지에서 변경사항을 확인하세요.");
			ArrayList<MemDto> dtos = service.loginView(param);
			model.addAttribute("loginView",dtos);
			
			return "redirect:memberView";
		}
		return "redirect:logout";	//관리자가 아닌 일반 회원의 경우 세션을 없앨 수 있게 로그아웃 페이지로 이동
	}
	
	/**관리자의 회원관리 페이지에서 등급을 올릴때 사용*/
	@RequestMapping("levelUp_admin")
	public String levelUp_admin(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("관리자 권한으로 등급을 올립니다.");
		service.levelUp_admin(param);
		
		System.out.println(param+"의 등급이 Lv3로 변경되었습니다.");
		return "redirect:memberView";
	}
	
	/**관리자의 회원관리 페이지에서 등급을 내릴때 사용*/
	@RequestMapping("levelDown_admin")
	public String levelDown_admin(@RequestParam HashMap<String, String> param, Model model) {
		System.out.println("관리자 권한으로 등급을 내립니다.");
		service.levelDown_admin(param);
		
		System.out.println(param+"의 등급이 Lv2로 변경되었습니다.");
		return "redirect:memberView";
	}
	
}
