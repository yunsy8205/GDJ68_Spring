package com.iu.main.student;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.main.bankbook.BankBookDTO;

@Repository
public class StudentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.iu.main.student.StudentDAO.";
	
	public List<StudentDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public StudentDTO getDetail(StudentDTO studentDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", studentDTO);
	}
			
	public int setDelete(StudentDTO studentDTO) throws Exception{

		return sqlSession.delete(NAMESPACE+"setDelete", studentDTO);

	}
	
	public int setUpdate(StudentDTO studentDTO) throws Exception{

		return sqlSession.update(NAMESPACE+"setUpdate", studentDTO);

	}
	
	public int setAdd(StudentDTO studentDTO) throws Exception{

		return sqlSession.insert(NAMESPACE+"setAdd", studentDTO);

	}


	

}
