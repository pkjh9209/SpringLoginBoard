package com.hj.loginboard.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	//ȸ������ dao
	public void memeberInsert(MemberDTO md) throws Exception{
		ss.insert("member.memberInsert",md);
	}
	//���̵� üũ dao
	public MemberDTO idCheck(String userId) throws Exception{
		return ss.selectOne("member.idCheck",userId);
	}
	//�α��� dao
	public MemberDTO memberLogin(MemberDTO md)throws Exception{
		return ss.selectOne("member.memberlogin",md);
	}
	//ȸ������ dao
	public void memberUpdate(MemberDTO md) throws Exception{
		ss.update("member.memberUpdate",md);
	}
	//ȸ�� ��ȸ dao
	public MemberDTO memberSelet(MemberDTO md) throws Exception{
		return ss.selectOne("member.memberSelect",md);
	}
	//ȸ��Ż�� dao
	public void memberDelete(MemberDTO md) throws Exception{
		ss.delete("member.memberDelete",md);
	}
}
