package com.semifinal.SCL.members.mapper;

import com.semifinal.SCL.members.entity.Members;

public interface IMembersMapper {

	
	//아이디 중복 확인
	int idCheck(String id);
	
	//회원 가입
	void join(Members member);
	
	//로그인
	//id를 통해 pw를 조회하는 메서드
	String login(String id);
	
	//회원 정보 얻어오기
	Members getInfo(String id);
	
	//회원 정보 수정
	void updateMember(Members member);
}
