package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//전체 리스트 가져오기
	public List<GuestVo> getGuestList(){
		
		System.out.println("===전체 리스트===");
		
		List<GuestVo> guestList =  sqlSession.selectList("guestbook.selectList2");
		System.out.println("Dao : guestList --> "+guestList);
		return guestList;
	}
	
	
		
	//저장
	public int guestInsert(GuestVo guestVo) {
		
		System.out.println("===저장===");
	
		//sql
		int count = sqlSession.insert("guestbook.insert",guestVo);
		
		System.out.println("count : " + count +", guestVo :" + guestVo);		
		return count;
	}
	
	//삭제	
	public int guestDelete(GuestVo guestVo) {
		
		System.out.println("===삭제===");
		
		//sql
		int count = sqlSession.delete("guestbook.delete",guestVo);
		
		System.out.println("count : " + count +", guestVo :" + guestVo);		
		return count;
		
	}
	
	

}
