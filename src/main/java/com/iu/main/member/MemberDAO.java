package com.iu.main.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired // 객체 주입
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.main.member.MemberDAO.";
	
	public int setFileJoin(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setFileJoin", memberFileDTO);
	}
	
	public int setJoin(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setJoin", memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", memberDTO);
	}
	
	public int setMemberUPdate(MemberDTO memberDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	
	public Long getIdTest(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getIdTest", memberDTO);
	}

}
