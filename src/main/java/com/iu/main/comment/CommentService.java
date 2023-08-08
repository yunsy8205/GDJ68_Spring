package com.iu.main.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	
	public List<CommentDTO> getList(CommentDTO commentDTO)throws Exception{
		return commentDAO.getList(commentDTO);
	}
	
	public int setAdd(CommentDTO commentDTO)throws Exception{
		return commentDAO.setAdd(commentDTO);
	}
	
}