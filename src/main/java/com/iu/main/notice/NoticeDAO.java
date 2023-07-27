package com.iu.main.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.member.MemberDTO;
import com.iu.main.util.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.notice.NoticeDAO.";
	
	//total : 전체 페이지 수
	public Long getTotal(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal", pager);
	}
	
	public List<NoticeDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public int setAdd(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAdd", noticeDTO);
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
	}
}
