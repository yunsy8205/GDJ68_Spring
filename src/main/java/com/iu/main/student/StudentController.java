package com.iu.main.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.main.bankbook.BankBookDTO;
import com.iu.main.bankbook.BankBookService;

@Controller
@RequestMapping("/student/*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getList(Model model) throws Exception {
		List<StudentDTO> ar	= studentService.getList();
		model.addAttribute("list", ar);
		
		return "student/list";	
	}
	
	@RequestMapping(value = "detail", method=RequestMethod.GET)
	public String getDetail(StudentDTO studentDTO, Model model)throws Exception{
		studentDTO = studentService.getDetail(studentDTO);
		model.addAttribute("dto", studentDTO);
		
		return "student/detail";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String setDelete(StudentDTO studentDTO) throws Exception{

		int result =studentService.setDelete(studentDTO);

		return "redirect:./list";

	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void setUpdate(StudentDTO studentDTO, Model model) throws Exception{

		studentDTO = studentService.getDetail(studentDTO);

		model.addAttribute("dto", studentDTO);

	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String setUpdate(StudentDTO studentDTO) throws Exception{

		int result = studentService.setUpdate(studentDTO);

		return "redirect:./detail?studNum="+studentDTO.getStudNum();
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void setAdd() throws Exception{

	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String setAdd(StudentDTO studentDTO) throws Exception{
		studentDTO.setStudTotal();
		studentDTO.setStudAvg();
		int result = studentService.setAdd(studentDTO);

		return "redirect:./list";
	}


}
