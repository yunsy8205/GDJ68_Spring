package com.iu.main.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.main.file.FileDTO;
import com.iu.main.member.MemberDTO;

@Component
public class FileManager extends AbstractView{//상속 추가
	
	//fileDelete
	public boolean fileDelete(FileDTO fileDTO, String path, HttpSession session) {
		//1. 삭제할 폴더의 실제 경로
		String realPath = session.getServletContext().getRealPath(path);//어플리케이션 객체 사용
		System.out.println(realPath);
		
		File file = new File(realPath, fileDTO.getFileName());
		
		return file.delete();
		
	}
	
	//fileSave
	public String fileSave(MultipartFile multipartFile, HttpSession session, String path)throws Exception{
		//파일의 정보를 이용해서 HDD에 파일을 저장
		//1. 어디에 저장<-- 매개변수로 보냄
		
		//2. 실제 경로 알아오기(톰캣이 위치한곳, 톰캣이 알고 있음)
		//jsp : application
		//java : servletContext
		String realPath = session.getServletContext().getRealPath(path);
		System.out.println(realPath);
			
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
		
		return uId;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("FileManager");
		String b = (String)model.get("bankbook");
		FileDTO fileDTO = (FileDTO)model.get("file");
		System.out.println(fileDTO);
		
		//1. 파일 경로 준비
		String path="/resources/upload/"+b;
		System.out.println(path);
		path=request.getSession().getServletContext().getRealPath(path); //실제 경로
		
		//2. File 객체 생성
		File file = new File(path, fileDTO.getFileName());
		//encoding은 안해줘도 된다.
		
		//3.파일의 크기 설정
		response.setContentLength((int)file.length());//int로 강제 형 변환
		// 다운로드시 얼마나 남았는지 확인시 비교하기 위해
		
		//4. 다운시 파일이름을 지정하고 인코딩 설정
		String downName = fileDTO.getOriginalName();
		downName = URLEncoder.encode(downName, "UTF-8");
		
		//5.Header 정보 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		//다운로드시 클라이언트에 들어가는 이름 : attachment fileName
		response.setHeader("Content-Transfer-Encoding", "binary");
		//binary 0과 1로 되는 파일
		
		//6.파일 전송
		FileInputStream is = new FileInputStream(file);
		//읽어드림
		OutputStream os = response.getOutputStream();
		//인풋에서 읽어드린 것을 아웃풋으로 넘김
		FileCopyUtils.copy(is, os);
		
		//7. 자원 해제
		os.close();
		is.close();
		
		
		
	}

}
