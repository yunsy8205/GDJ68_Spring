package com.iu.main.errors;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice //예외처리 Controller
public class ErrorController {
	
	//app 내에서 발생한 모든 exception을 처리하는 Controller
	//예외가 발생하면 다 이쪽으로 옴
	
	@ExceptionHandler(NoHandlerFoundException.class)
	// 핸들러를 찾을 수 없을 때 익셉션타입을 모를때
 	public String frontError() throws Exception{
		return "erros/front_error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String error1() throws Exception {
		System.out.println("Null pointer Exception 발생");
		return "erros/front_error";
	}
	
	@ExceptionHandler(TypeMismatchException.class)
	public void error2() throws Exception {
		
	}
	
	@ExceptionHandler(Exception.class)
	public String error3(Exception ex) throws Exception {
		// 마지막으로 남은 exception을 Exception으로 처리
		System.out.println(ex.getMessage());
		return "erros/front_error";
	}
}
