package com.hj.loginboard.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	
	@Autowired
	private SqlSession ss;
	
	//��� ��ȸ dao
	public List<CommentDTO> viewComment(int boardIdx) throws Exception{
		return ss.selectList("freeboard.viewComment",boardIdx);
	}
	//��� �ۼ� dao
	public void writeComment(CommentDTO cd) throws Exception{
		ss.insert("freeboard.writeComment",cd);
	}
}
