package com.iu.main.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.board.BoardDAO;
import com.iu.main.board.BoardDTO;
import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.board.notice.NoticeDAO.";
	
	public int setFileAdd(NoticeFileDTO noticeFileDTO)throws Exception {
		return sqlSession.insert(NAMESPACE+"setFileAdd", noticeFileDTO);
	}
	
	//total : 전체 페이지 수
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	
	public List<BoardDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public int setAdd(BoardDTO boardDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}
	
	public NoticeDTO getDetail(BoardDTO boardDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	public int setDelete(BoardDTO boardDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}
	
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		
		return 0;
	}

}
