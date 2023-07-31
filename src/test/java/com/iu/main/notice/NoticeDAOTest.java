package com.iu.main.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.main.MyTest;
import com.iu.main.board.notice.NoticeDAO;
import com.iu.main.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getListTest()throws Exception {
//		List<NoticeDTO> ar = noticeDAO.getList();
//		assertNotEquals(0, ar.size());
//		
//	}
	
	@Test
	public void setAddTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		int result = noticeDAO.setAdd(noticeDTO);
		assertNotEquals(0, result);
	}
}
