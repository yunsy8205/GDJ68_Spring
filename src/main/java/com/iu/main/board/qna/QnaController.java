package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "qna";
	}
	
	//qna
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(Long num, Model model) throws Exception{
		
		model.addAttribute("num", num);
		return "board/reply";
	}
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String replay(QnaDTO qnaDTO, MultipartFile [] photos, HttpSession session) throws Exception{
		
		qnaService.setReplyAdd(qnaDTO, photos, session);
		return "redirect:list";
	}
	
	//list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception{

		List<BoardDTO> ar = qnaService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	//add
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd()throws Exception{
		return "board/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(QnaDTO qnaDTO, MultipartFile [] photos, HttpSession session)throws Exception{
		int result = qnaService.setAdd(qnaDTO, photos, session);
		
		return "redirect:./list";
	}
	
	//detail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(QnaDTO qnaDTO, Model model)throws Exception{
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("notice", boardDTO);
		
		return "board/detail";
	}
	
	//delete
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String setDelete(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.setDelete(qnaDTO);
		
		return "redirect:./list";
	}
	
	//update
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String setUpdate(QnaDTO qnaDTO, Model model) throws Exception{
		BoardDTO boardDTO =qnaService.getDetail(qnaDTO);
		model.addAttribute("notice", boardDTO);
		
		return "board/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(QnaDTO qnaDTO, MultipartFile [] photos, HttpSession session) throws Exception{
		int result = qnaService.setUpdate(qnaDTO, photos, session);
		
		return "redirect:./detail?num="+qnaDTO.getNum();
	}
}
