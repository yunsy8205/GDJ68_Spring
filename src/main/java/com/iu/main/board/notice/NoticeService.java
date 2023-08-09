package com.iu.main.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.bankbook.BankBookFileDTO;
import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		pager.makeRowNum();//페이지에 출력할 시작행과 끝행
		Long total = noticeDAO.getTotal(pager);//행의 총 개수
		pager.makePageNum(total);//게시물의 갯수(행의 총 갯수)를 이용해 전체페이지수와 전체페이지블럭수 구하기
								//현재 페이지번호에 맞는 페이지블록번호 구하기
								//현재 블럭번호의 시작페이지번호아 끝페이지번호 구하기
		
		return noticeDAO.getList(pager);
	}
	
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception{
		int result = noticeDAO.setAdd(boardDTO);
		String path = "/resources/upload/notice/";
		
		for(MultipartFile multipartFile:files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, session, path);
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			noticeFileDTO.setNum(boardDTO.getNum());// 번호가 잘 저장되나?
			
			result = noticeDAO.setFileAdd(noticeFileDTO);
		}
		
		return result;
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
		return noticeDAO.getDetail(boardDTO);
	}
	
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception{
		return noticeDAO.setUpdate(boardDTO);
	}
	
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return noticeDAO.setDelete(boardDTO);
	}

}
