package com.iu.main.bankBook;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;
import com.iu.main.bankBook.BankBookDAO;
import com.iu.main.bankBook.BankBookDTO;
import com.iu.main.util.Pager;

public class BankBookDAOTest extends MyTest{
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	//@Test
	public void getListTest()throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", 1);
		map.put("lastRow", 10);
//		
//		List<BankBookDTO> ar = bankBookDAO.getList(pager);
//		System.out.println(ar.get(0).getBookNum());
//		System.out.println(ar.get(9).getBookNum());
	}
	//@Test
	public void addTest()throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		for(int i=0;i<30;i++) {
			bankBookDTO.setBookName("청년청약통장"+i);
			bankBookDTO.setBookContents("청년청약통장 내용"+i);
			bankBookDTO.setBookRate(2.3);
			bankBookDTO.setBookSale(1);
			
			bankBookDAO.setAdd(bankBookDTO);
			
		}
		System.out.println("Finish");
	}

}
