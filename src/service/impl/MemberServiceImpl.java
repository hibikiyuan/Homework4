package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private static MemberDaoImpl memberdaoimpl=new MemberDaoImpl();
	
	public static void main(String[] args) {
		
	}

	@Override
	public void addMember(Member member) {
		memberdaoimpl.add(member);
		
	}

	@Override
	public Member login(String username, String password) {
		Member member=null;
		List<Member> l=memberdaoimpl.selectUsernameAndPassword(username, password);
		if(l.size()!=0)
		{
			member=l.get(0);
		}		
		
		return member;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		
		return !memberdaoimpl.selectByUsername(username).isEmpty();
		
	}
}
