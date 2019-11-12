package com.hj.loginboard.freeboard;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FreeboardService {
	
	
	@Autowired
	private FreeboardDAO dao;
	//���ۼ�
	public void write(FreeboardDTO fd) throws Exception{
		dao.boardWrite(fd);
	}
	//����ȸ
	public FreeboardDTO select(int idx) throws Exception{
		return dao.boardSelect(idx);
	}
	//�ۼ���
	public void update(FreeboardDTO fd) throws Exception{
		dao.boardUpdate(fd);
	}
	//�ۻ���
	public void delete(int idx) throws Exception{
		dao.boardDelete(idx);
	}
	//�۸��
	public List<FreeboardDTO> list(String pageNum) throws Exception{
		return dao.list(pageNum);
	}
	
}
