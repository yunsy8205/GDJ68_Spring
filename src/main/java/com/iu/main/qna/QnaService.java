package com.iu.main.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.notice.NoticeDAO;
import com.iu.main.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> getList(Pager pager)throws Exception{

		pager.makeRowNum();//startNum과 lastNum을 구함 (페이지에 출력할)
		Long total = qnaDAO.getTotal(pager);// kind와 search에 해당하는 행 총수 구함
		pager.makePageNum(total);//행갯수로 전체 페이지수 구함-> 페이지수의 block수 구함-> 

		return qnaDAO.getList(pager);
	}

}
