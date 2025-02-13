package service;

import model.Member;

public interface MemberService {
		//Create
		void addMember(Member member);
		
		//Read
		Member login(String username, String password);
		boolean isUsernameBeenUse(String username);
}
