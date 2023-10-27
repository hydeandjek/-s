package com.semifinal.SCL.members.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.semifinal.SCL.members.dto.MembersInfoResponseDTO;
import com.semifinal.SCL.members.dto.MembersRequsetDTO;
import com.semifinal.SCL.members.entity.Members;
import com.semifinal.SCL.members.mapper.IMembersMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MembersService {
	
	private final IMembersMapper mapper;
	private final BCryptPasswordEncoder encoder;
	
	public int idCheck(String account) {
		return mapper.idCheck(account);
	}

	public void join(MembersRequsetDTO dto) {
		log.info("암호화하기 전 pw : {}",dto.getPw());
		String cordPw = encoder.encode(dto.getPw());
		dto.setPw(cordPw);
		Members member = Members.builder()
				.id(dto.getId())
				.pw(dto.getPw())
				.email(dto.getEmail())
				.phone(dto.getPhone())
				.build();
		
		mapper.join(member);
	}

	public String login(String id,String pw) {
		String dbPw =mapper.login(id);
		if(dbPw!=null) {
			// 날것의 비밀번호와 암호화된 비밀번호의 일치 여부를 알려주는 matches()
			if(encoder.matches(pw, dbPw)) {
				return id;
			}
		}
		return null;
		
	}

	public MembersInfoResponseDTO getInfo(String memberId) {
		Members member = mapper.getInfo(memberId);
		return MembersInfoResponseDTO.toDTO(member);
	}
	
	
	
	

}
