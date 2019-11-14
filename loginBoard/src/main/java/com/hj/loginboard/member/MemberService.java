package com.hj.loginboard.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;
	//회원가입 service
	public void memeberInsert(MemberDTO md) throws Exception{
		dao.memeberInsert(md);
	}
	//로그인 service
	public MemberDTO memberLogin(MemberDTO md)throws Exception{
		return dao.memberLogin(md);
	}
}
