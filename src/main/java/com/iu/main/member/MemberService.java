package com.iu.main.member;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private FileManager fileManager;
	
	//@Autowired
	private HttpSession session;//나중에 문제가 생길수도 이씅ㅁ
	
	
	public int setJoin(MemberDTO memberDTO, MultipartFile multipartFile, HttpSession session)throws Exception{
		int result = memberDAO.setJoin(memberDTO);
		String path="/resources/upload/member/";
		
		if(!multipartFile.isEmpty()) {
		String fileName = fileManager.fileSave(multipartFile, session, path);
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setOriginalName(multipartFile.getOriginalFilename());
		memberFileDTO.setFileName(fileName);
		result = memberDAO.setFileJoin(memberFileDTO);

		}
		return result;
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.getLogin(memberDTO);
	}
	
	public int setMemberUPdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberUPdate(memberDTO);
	}
	
	public Long getIdTest(MemberDTO memberDTO)throws Exception{
		return memberDAO.getIdTest(memberDTO);
	}
}
