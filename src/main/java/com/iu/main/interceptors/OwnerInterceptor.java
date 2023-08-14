package com.iu.main.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.main.board.BoardDTO;
import com.iu.main.member.MemberDTO;

public class OwnerInterceptor extends HandlerInterceptorAdapter{
	
	//게시판.
	//수정시 로그인한 유저와 작성자가 일치
	//컨트롤러 진입 전 컨트롤러 빠져나오전 둘 중 하나
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		String method = request.getMethod();
		if(method.equals("POST")) {
			return;
		}
		
		MemberDTO memberDTO= (MemberDTO)request.getSession().getAttribute("member");//아이디 꺼내야됨
		Map<String, Object> map= modelAndView.getModel();
		
		BoardDTO boardDTO = (BoardDTO)map.get("notice");

		if(!memberDTO.getId().equals(boardDTO.getName())) {
			modelAndView.addObject("message", "작성자만 가능합니다.");
			modelAndView.addObject("url", "./list");
			modelAndView.setViewName("commons/result");
		}
	}
}

