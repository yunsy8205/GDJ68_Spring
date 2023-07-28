package com.iu.main.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.member.MemberDTO;

@Component
public class FileManager {
	
	//fileSave
	public String fileSave(MultipartFile multipartFile, HttpSession session, String path)throws Exception{
		//파일의 정보를 이용해서 HDD에 파일을 저장
		//1. 어디에 저장<-- 매개변수로 보냄
		
		//2. 실제 경로 알아오기(톰캣이 위치한곳, 톰캣이 알고 있음)
		//jsp : application
		//java : servletContext
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
		System.out.println("2");
		
		File file = new File(realPath);
		
		if(!file.exists()) {//없을 때 폴더 만들자
			file.mkdirs();
		}
		
		//3. 어떤이름으로 저장??
		//1) 시간을 이용
//		Calendar ca = Calendar.getInstance();
//		long result =ca.getTimeInMillis();
//		file = new File(file, result+"_"+multipartFile.getOriginalFilename());
		//getOriginalFilename은 원래 파일이름 그대로 적용한다는 의미
		
		//2) API 사용
		String uId=UUID.randomUUID().toString();
		uId=uId+"_"+multipartFile.getOriginalFilename();
		System.out.println(uId);
		file = new File(file, uId);
		
		//4. 파일을 저장
		//A. Spring에서 제공하는 API CopyUtilis의 copy메서드
		//FileCopyUtils.copy(multipartFile.getBytes(), file); //B와 충돌을 방지하기 위해 주석처리
		
		//B. MultipartFile의 transferTo메서드
		multipartFile.transferTo(file);
		System.out.println("3");
		return uId;
	}

}
