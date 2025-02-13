package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao {
	
	private static Connection conn=DbConnection.getDb();
	
	public static void main(String[] args) {

	}

	@Override
	public void add(Member member) {
		String sql="insert into member(id,name,username,password,address,mobile) "
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, member.getId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getUsername());
			ps.setString(4, member.getPassword());
			ps.setString(5, member.getAddress());
			ps.setString(6, member.getMobile());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> selectAll() {
		String sql = "SELECT * FROM member";
		List<Member> allMember=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet resultset=ps.executeQuery();
			while(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				allMember.add(m);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allMember;
	}

	@Override
	public List<Member> selectUsernameAndPassword(String username, String password) {
		String sql = "select * from member where username=? and password=?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet resultset=ps.executeQuery();
			
			if(resultset.next()) {
				Member m=new Member();
				//m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectById(String id) {
		String sql = "select * from member where id=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet resultset=ps.executeQuery();
			if(resultset.next()) {
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByUsername(String username) {
		String sql = "select * from member where username=?";
		List<Member> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet resultset=ps.executeQuery();
			if(resultset.next()) {
				Member m=new Member();
				//m.setId(resultset.getString("id"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Member member) {
		String sql="update member set name=?,password=?,address=?,mobile=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getAddress());
			ps.setString(4,member.getMobile());
			ps.setInt(5,member.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String id) {
		String sql="delete from member where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
