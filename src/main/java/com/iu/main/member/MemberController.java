package com.iu.main.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void getLogin()throws Exception{
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String getLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		//request.getSession을 해서 매개변수로 session을 보내준다.
		memberDTO = memberService.getLogin(memberDTO);
		if(memberDTO != null) {
			//로그인성공
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect:../";
				//return "redirect:/"; 절대경로 
	}
	
	@RequestMapping(value="logout", method = RequestMethod.GET)//a태그라서 get 방식
	public String getLogout(HttpSession session)throws Exception{
		
		session.invalidate();
		
		return "redirect:../";
	}
	
	@RequestMapping(value="mypage", method = RequestMethod.GET)
	public void getMypage()throws Exception{
		//session에 이미 DB정보가 존재한다. 로그인 상태이므로
	}
	
	//update
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public void setMemberUpdate()throws Exception{
		
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String setMemberUpdate(MemberDTO memberDTO, HttpSession session)throws Exception{
		MemberDTO sessionMember=(MemberDTO)session.getAttribute("member");//session에 member가 있고 그 안에 아이디가 있다.(object 타입)
		memberDTO.setId(sessionMember.getId());//보안을 위해 세션 이용
		int result = memberService.setMemberUPdate(memberDTO);
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		
		return "redirect:./mypage";
		
	}
}
