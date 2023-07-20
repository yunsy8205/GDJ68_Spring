package com.iu.main.bankbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public void service() {
		System.out.println("service");
		bankBookDAO.dao();
	}
	
}
