package com.iu.main.bankbook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankBookController {
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String getList() throws Exception{
		System.out.println("list");
		bankBookService.service();
		// request 사용 불가 : 매개변수로 받지 않음
		return "bankbook/list";
	}
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public ModelAndView getDetail() throws Exception{
		System.out.println("detail");
		//Model(request와 비슷한 역할)+View(jsp경로)
		ModelAndView mv = new ModelAndView();
		// request 사용 불가 : 매개변수로 받지 않음
		mv.addObject("num", 123); //request.seAttribute와 같은 의미
		mv.setViewName("bankbook/detail");
		//return "bankbook/detail";
		return mv;
	}
	
	// 오는 URL 주소 중 매칭되는 것을 value에 써줌
	@RequestMapping(value = "add", method = RequestMethod.GET )
	public ModelAndView setAdd(ModelAndView mv) throws Exception{ //Model을 매개변수로 받아서 사용가능 
		int num=333;
		//return "bankbook/add";                            디스패처 서블릿이 만들어서 넣어줌  
		//view의 경로명이 없으면 URL주소가 경로명으로 대체 됨
		mv.addObject("num", num);
		mv.setViewName("bankbook/add");
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST ) // 파라미터로 오는 값을 파라미터 이름이랑 다른 값을 써야 한다면 아래처럼 파라미터이름을 직접 입력해서 지정해줘야한다.
																// 기본값을 defaultValute로 쓸수 있다. null값일 때
	public String setAdd(Model model, BankBookDTO bankBookDTO) throws Exception{
		//파라미터로 보낸 데이터를 매개변수로 받을 수 있다. 매개변수를 원하는 타입으로 받을 수있다. 파라미터이름과 변수명이 같아야 한다.
		int num =111;//리턴은 스트링으로 하고 싶지만 값을 담아야 할 때

		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		System.out.println(bankBookDTO.getBookSale());
		
		for(int i=0;i<bankBookDTO.getSports().length;i++) {
			System.out.println(bankBookDTO.getSports()[i]);
		}
		
//		bankBookDTO.setBookName(request.getParameter("bookName"));
//		
//		System.out.println(request.getParameter("bookName"));
//		System.out.println(request.getParameter("bookSale"));
//		System.out.println(request.getParameter("sports"));
//		String [] sports =request.getParameterValues("sports");
//		for(int i=0;i<sports.length;i++) {
//			System.out.println(sports[i]);
//		}
		model.addAttribute("num", num);//리턴 시키지 않아도 자동으로 넘어감
		return "redirect:./list"; //포워드가 아닌 리다이렉트 할 것을 써줘야함
	}
	
}
