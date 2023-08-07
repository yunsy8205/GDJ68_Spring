package com.iu.main.bookAccount;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Repository
public class BookAccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.bookAccount.BookAccountDAO.";
	
	public List<BookAccountDTO> getList(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}
	
	public BookAccountDTO getDetail(BookAccountDTO bookAccountDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", bookAccountDTO);
	}
	
	public int setAdd(BookAccountDTO bookAccountDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", bookAccountDTO);
	}
	
	public int setDelete(BookAccountDTO bookAccountDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", bookAccountDTO);
	}
	
	public int setUpdate(BookAccountDTO bookAccountDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", bookAccountDTO);
	}
}
