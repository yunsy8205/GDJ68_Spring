package com.iu.main.bookAccount;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;
import com.iu.main.member.MemberDTO;

public class bookAccountTest extends MyTest{
	
	@Autowired
	private BookAccountDAO bookAccountDAO;
	
//	//@Test
//	public void getListTest() throws Exception{
//		MemberDTO dto = new MemberDTO();
//		dto.setId("111111");
//		List<BookAccountDTO> ar = bookAccountDAO.getList(dto);
//		//0과 ar.size()가 같은지 물어보는 메서드로 assertNotEquals를 사용해도 된다. (서로반대의미)
//		assertNotEquals(0, ar.size());///List는 만들어져서 null이 아니지만(DTO가 null인것)
//									//해당하는 정보가 없다면 사이즈는 0이기때문에 사이즈로 평가한다.
////		for(int i=0; i< ar.size(); i++) {
////			System.out.println(ar.get(i).getAccount());
////		}
//	}
	
	//@Test
	public void getDetailTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setAccountNum(1L);
		dto = bookAccountDAO.getDetail(dto);
		System.out.println(dto.getAccount());
	}
	
	@Test
	public void setAddTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setId("yun8205");
		dto.setBookNum(1002L);
		Calendar ca = Calendar.getInstance();
		dto.setAccount(ca.getTimeInMillis());
		dto.setAccountPassword("0000");
		dto.setAccountBalance(10000L);
		int result = bookAccountDAO.setAdd(dto);
		
		assertEquals(1, result);
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
	
	//@Test
	public void setUpdateTest() throws Exception{
		BookAccountDTO dto = new BookAccountDTO();
		dto.setAccountNum(3L);
		dto.setAccountPassword("1234");
		dto.setAccountBalance(1000000L);
		
		int result = bookAccountDAO.setUpdate(dto);
		if(result==1) {
			System.out.println("수정성공");
		}else {
			System.out.println("실패");
		}
	}
	
	
}
