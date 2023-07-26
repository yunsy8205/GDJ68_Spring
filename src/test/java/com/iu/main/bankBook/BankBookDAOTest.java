package com.iu.main.bankBook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;
import com.iu.main.bankbook.BankBookDAO;
import com.iu.main.bankbook.BankBookDTO;

public class BankBookDAOTest extends MyTest{
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
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
