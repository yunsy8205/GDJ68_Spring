package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoardName() {
		return "notice";
	}// @ModelAttribute를 해주면 모든 메서드마다 리턴해줄 때 모델에 담김.
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception{
		// 파라미터로 받은 page Pager 안의 멤버변수 page에 저장
		List<BoardDTO> ar = noticeService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		
		return "board/list";
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "board/add";
		
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String setAdd(NoticeDTO noticeDTO, MultipartFile [] photos, HttpSession session, Model model) throws Exception{
		int result = noticeService.setAdd(noticeDTO, photos, session);
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("url", "list"); //./ 안치면 현재위치 
		return "commons/result";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) throws Exception{
		BoardDTO boardDTO = noticeService.getDetail(noticeDTO);
		
		String message="";
		if(boardDTO != null) {
			model.addAttribute("notice", boardDTO);
			return "board/detail";
		}else {
			message="정보가 없습니다.";
			model.addAttribute("message", message);
			model.addAttribute("url", "list");
			return "commons/result";
			
		}
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String setUpdate(NoticeDTO noticeDTO, Model model) throws Exception{
		BoardDTO boardDTO=noticeService.getDetail(noticeDTO);
		model.addAttribute("notice", boardDTO);
		return "board/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO, MultipartFile [] photos, HttpSession session) throws Exception{
		int result = noticeService.setUpdate(noticeDTO, photos, session);
		return "redirect:./detail?num="+noticeDTO.getNum();		
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String setDelete(NoticeDTO noticeDTO) throws Exception{
		int result = noticeService.setDelete(noticeDTO);
		return "redirect:./list";
	}
	
	//작성중 이미지 올리기
	@PostMapping("setContentsImg")
	public String setContentsImg(MultipartFile files, HttpSession session, Model model)throws Exception{

		String path = noticeService.setContentsImg(files, session);
		model.addAttribute("result", path);
		System.out.println(path);
		return "commons/ajaxResult";
	}
	
	//작성중 이미지 삭제
	@PostMapping("setContentsImgDelete")
	public String setContentsImgDelete(String path, HttpSession session, Model model)throws Exception{
		boolean check = noticeService.setContentsImgDelete(path,session);
		model.addAttribute("result", check);
		
		return "commons/ajaxResult";
	}



}
