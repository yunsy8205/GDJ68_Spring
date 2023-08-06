package com.iu.main.bookAccount;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;

public class bookAccountTest extends MyTest{
	
	@Autowired
	private BookAccountDAO bookAccountDAO;
	
	//@Test
	public void getListTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setId("yun8205");
		List<BookAccountDTO> ar = bookAccountDAO.getList(dto);
		for(int i=0; i< ar.size(); i++) {
			System.out.println(ar.get(i).getAccount());
		}
	}
	
	//@Test
	public void getDetailTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setAccountNum(1L);
		dto = bookAccountDAO.getDetail(dto);
		System.out.println(dto.getAccount());
	}
	
	//@Test
	public void setAddTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setId("yun8205");
		dto.setBookNum(98L);
		Calendar ca = Calendar.getInstance();
		dto.setAccount(ca.getTimeInMillis());
		dto.setAccountPassword(1234);
		dto.setAccountBalance(100000L);
		int result = bookAccountDAO.setAdd(dto);
		
		if(result==1) {
			System.out.println("추가성공");
		}else {
			System.out.println("실패");
		}
	}
	
	//@Test
	public void setDeleteTest()throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setAccountNum(2L);
		int result = bookAccountDAO.setDelete(dto);
		
		if(result==1) {
			System.out.println("삭제성공");
		}else {
			System.out.println("실패");
		}
	}
	
	@Test
	public void setUpdateTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setAccountNum(3L);
		dto.setAccountPassword(1234);
		dto.setAccountBalance(1000000L);
		
		int result = bookAccountDAO.setUpdate(dto);
		if(result==1) {
			System.out.println("수정성공");
		}else {
			System.out.println("실패");
		}
	}
	
	
}
