package com.hj.loginboard.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	@Autowired
	private SqlSession ss;
	//ȸ������ dao
	public void memeberInsert(MemberDTO md) throws Exception{
		ss.insert("member.memberInsert",md);
	}
	//�α��� dao
	public MemberDTO memberLogin(MemberDTO md)throws Exception{
		return ss.selectOne("member.memberlogin",md);
	}
	
}
