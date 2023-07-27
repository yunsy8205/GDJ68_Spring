package com.iu.main.member;

import java.io.File;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//@Autowired
	private HttpSession session;//나중에 문제가 생길수도 이씅ㅁ
	
	public int setJoin(MemberDTO memberDTO, MultipartFile multipartFile, HttpSession session)throws Exception{
		//파일의 정보를 이용해서 HDD에 파일을 저장
		//1. 어디에 저장
		String path="/resources/upload/member/";
		
		//2. 실제 경로 알아오기(톰캣이 위치한곳, 톰캣이 알고 있음)
		//jsp : application
		//java : servletContext
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		if(!file.exists()) {//없을 때 폴더 만들자
			file.mkdirs();
		}
		
		Calendar ca = Calendar.getInstance();
		long result =ca.getTimeInMillis();
		file = new File(file, result+"_"+multipartFile.getOriginalFilename());
		//오리지널 파일이름은 원래 파일이름 그대로 적용
		
		//4. 파일을 저장
		//A. Spring에서 제공하는 API CopyUtilis의 copy메서드
		//FileCopyUtils.copy(multipartFile.getBytes(), file); //B와 충돌을 방지하기 위해 주석처리
		
		//B. MultipartFile의 transferTo메서드
		multipartFile.transferTo(file);
		
		return 0;//memberDAO.setJoin(memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setMemberUPdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberUPdate(memberDTO);
	}
}
