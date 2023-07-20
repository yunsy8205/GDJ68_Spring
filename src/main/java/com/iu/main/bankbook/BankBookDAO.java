package com.iu.main.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//BankBookMapper와 같은것을 씀
	private final String NAMESPACE="com.iu.main.bankBook.BankBookDAO.";
	//detail
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		
		// 연결을 mybatis에서 함 연결 끊는 것도 mybatis에서 해줌
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", bankBookDTO);
		// getDetail은 위에 NAMESPACE의 아이디를 의미한다. 예전 ?에 해당하는 것으로 마지막은 DB에 보내줄 것(DTO) 넘겨줌
	}
}
