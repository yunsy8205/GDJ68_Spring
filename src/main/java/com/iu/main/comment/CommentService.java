package com.iu.main.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.main.util.Pager;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	
	public List<CommentDTO> getList(CommentDTO commentDTO, Pager pager)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		pager.setPerPage(2L);
		pager.makeRowNum();
		pager.makePageNum(commentDAO.getTotal(commentDTO));
		map.put("pager", pager);
		map.put("comment", commentDTO);
		return commentDAO.getList(map);
	}
	
	public int setAdd(CommentDTO commentDTO)throws Exception{
		return commentDAO.setAdd(commentDTO);
	}
	
}