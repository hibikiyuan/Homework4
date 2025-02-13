package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
		//create
		void add(Member member);
		
		//read
		List<Member> selectAll();//select * from member
		List<Member> selectUsernameAndPassword(String username,String password);
		List<Member> selectById(String id);
		List<Member> selectByUsername(String username);
		
		//update
		void update(Member member);
		
		//delete
		void delete(String id);
}
