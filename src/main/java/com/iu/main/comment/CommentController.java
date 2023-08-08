package com.iu.main.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("list")
	public void getList(CommentDTO commentDTO, Model model) throws Exception{
		List<CommentDTO> ar = commentService.getList(commentDTO);
		model.addAttribute("list", ar);
		
	}

}
