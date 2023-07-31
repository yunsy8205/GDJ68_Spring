package com.iu.main.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;
import com.iu.main.board.BoardDTO;
import com.iu.main.board.qna.QnaDAO;
import com.iu.main.board.qna.QnaDTO;

public class QnaDAOTest extends MyTest {
	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void setAddTest() throws Exception{
		QnaDTO boardDTO = new QnaDTO();
		boardDTO.setName("yun8205");
		boardDTO.setSubject("test2");
		boardDTO.setContents("test contents2");
		
		int result = qnaDAO.setAdd(boardDTO);
		assertEquals(1, result);
	}
}
