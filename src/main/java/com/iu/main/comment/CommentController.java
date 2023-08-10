package com.iu.main.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("list")
	public void getList(CommentDTO commentDTO, Pager pager, Model model) throws Exception{
		List<CommentDTO> ar = commentService.getList(commentDTO, pager);
		model.addAttribute("list", ar);
		
	}
	
	@PostMapping("add")
	public String setAdd(CommentDTO commentDTO, HttpSession session, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		commentDTO.setId(memberDTO.getId());
		int result = commentService.setAdd(commentDTO);
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
				
	}

}
