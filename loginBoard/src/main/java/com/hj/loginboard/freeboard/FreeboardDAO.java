package com.hj.loginboard.freeboard;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hj.loginboard.freeboard.FreeboardDTO;
@Repository
public class FreeboardDAO {
	
	@Autowired SqlSession ss;
	
	//���ۼ� (mapper - namespace.id)
	public void boardWrite(FreeboardDTO fd) throws Exception{
		ss.insert("freeboard.boardWrite",fd);
	}
	
	//����ȸ
	public FreeboardDTO boardSelect(int idx) throws Exception{
		return ss.selectOne("freeboard.boardSelect",idx);
	}
	
	//�ۼ���
	public void boardUpdate(FreeboardDTO fd) throws Exception{
		ss.update("freeboard.boardUpdate",fd);
	}
	
	//�ۻ���
	public void boardDelete(int idx) throws Exception{
		
		ss.delete("freeboard.boardDelete",idx);
	}
	
	//�� ���
	public List<FreeboardDTO> list(String pageNum) throws Exception{
		System.out.println("pageNum = " + pageNum);
		int num = pageNum==null? 1: Integer.parseInt(pageNum);
		num = 10*(num-1);
		return ss.selectList("freeboard.pageList");
	}
	
}
