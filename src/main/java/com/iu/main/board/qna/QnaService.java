package com.iu.main.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.BoardService;
import com.iu.main.board.notice.NoticeDAO;
import com.iu.main.util.FileManager;
import com.iu.main.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private FileManager fileManager;
	
	public List<BoardDTO> getList(Pager pager)throws Exception{

		pager.makeRowNum();//startNum과 lastNum을 구함 (페이지에 출력할)
		Long total = qnaDAO.getTotal(pager);// kind와 search에 해당하는 행 총수 구함
		pager.makePageNum(total);//행갯수로 전체 페이지수 구함-> 페이지수의 block수 구함-> 

		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		int result = qnaDAO.setAdd(boardDTO);
		String path = "/resources/upload/qna/";
		
		for(MultipartFile multipartFile:files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, session, path);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			qnaFileDTO.setNum(boardDTO.getNum());
			
			result = qnaDAO.setFileAdd(qnaFileDTO);
			
		}
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.setDelete(boardDTO);
	}
	
	public int setReplyAdd(QnaDTO qnaDTO, MultipartFile [] files, HttpSession session)throws Exception{
		BoardDTO parentDTO = new BoardDTO();
		parentDTO.setNum(qnaDTO.getNum());
		
		parentDTO = qnaDAO.getDetail(parentDTO);
		QnaDTO p = (QnaDTO)parentDTO;
		qnaDTO.setRef(p.getRef());
		qnaDTO.setStep(p.getStep()+1);
		qnaDTO.setDepth(p.getDepth()+1);
		
		int result = qnaDAO.setStepUpdate(p);
		
		result = qnaDAO.setReplyAdd(qnaDTO);
		//file 저장
		String path = "/resources/upload/qna/";
		
		for(MultipartFile multipartFile:files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, session, path);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriginalName(multipartFile.getOriginalFilename());
			qnaFileDTO.setNum(qnaDTO.getNum());
			
			result = qnaDAO.setFileAdd(qnaFileDTO);
			
		}
		return result;
	}

}
