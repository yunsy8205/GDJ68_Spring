package com.iu.main.board.qna;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iu.main.board.BoardDTO;
import com.iu.main.board.notice.NoticeFileDTO;

public class QnaDTO extends BoardDTO{
	

	private Long ref;
	private Long step;
	private Long depth;
	private List<QnaDTO> fileDTOs;
	
	public List<QnaDTO> getFileDTOs() {
		return fileDTOs;
	}
	public void setFileDTOs(List<QnaDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
}
