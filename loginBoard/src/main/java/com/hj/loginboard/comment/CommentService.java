package com.hj.loginboard.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentService {
	
	@Autowired
	private CommentDAO dao;

	//��� ��ȸ service
	public List<CommentDTO> viewComment(int boardIdx) throws Exception{
		return dao.viewComment(boardIdx);
	}
	//��� ���� service	
	public void writeComment(CommentDTO cd) throws Exception{
		dao.writeComment(cd);
	}
}
