package com.hj.loginboard.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	//ȸ������ service
	public void memeberInsert(MemberDTO md) throws Exception{
		dao.memeberInsert(md);
	}
	//���̵�üũ service
	public MemberDTO idCheck(String userId) throws Exception{
		return dao.idCheck(userId);
	}
	//�α��� service
	public MemberDTO memberLogin(MemberDTO md) throws Exception{
		return dao.memberLogin(md);
	}
	//ȸ������ service
	public void memberUpdate(MemberDTO md) throws Exception{
		dao.memberUpdate(md);
	}
	//ȸ����ȸ service
	public MemberDTO memberSelet(MemberDTO md) throws Exception{
		return dao.memberSelet(md);
	}
	//ȸ�� Ż�� service
	public void memberDelete(MemberDTO md) throws Exception{
		dao.memberDelete(md);
	}
}
