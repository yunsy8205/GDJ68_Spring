package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.bankbook.BankBookDAO;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public List<StudentDTO> getList() throws Exception{
		return studentDAO.getList();	
	}

}
