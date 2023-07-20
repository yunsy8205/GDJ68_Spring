package com.iu.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class FrontController {
	//home
	// /(루트)주소가 왔을 때 실행, index.jsp
	
	@RequestMapping(value="/")
	public String Home() throws Exception{
		System.out.println("index");
		return "index";
	}
	
}
