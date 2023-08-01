package com.iu.main.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.board.BoardDAO;
import com.iu.main.board.BoardDTO;
import com.iu.main.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.board.qna.QnaDAO.";
	
	//total
	public Long getTotal(Pager pager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	//list
	public List<BoardDTO> getList(Pager pager)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", boardDTO);
	}

	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int setFileAdd(QnaFileDTO qnaFileDTO)throws Exception{
		
		return sqlSession.insert(NAMESPACE+"setFileAdd", qnaFileDTO);
	}
	
	public int setReplyAdd(QnaDTO qnaDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setReplyAdd", qnaDTO);
	}
	
	public int setStepUpdate(QnaDTO qnaDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setStepUpdate", qnaDTO);
	}
	
}
