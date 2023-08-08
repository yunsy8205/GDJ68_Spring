package com.iu.main.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.comment.CommentDAO.";
	
	public List<CommentDTO> getList(CommentDTO commentDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", commentDTO);
	}
	
}
