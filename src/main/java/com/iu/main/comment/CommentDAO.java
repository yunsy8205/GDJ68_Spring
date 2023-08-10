package com.iu.main.comment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.comment.CommentDAO.";
	
	public List<CommentDTO> getList(Map<String, Object> map)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}

	public int setAdd(CommentDTO commentDTO) {
		return sqlSession.insert(NAMESPACE+"setAdd", commentDTO);
	}
	
	public long getTotal(CommentDTO commentDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", commentDTO);
	}
	
}
