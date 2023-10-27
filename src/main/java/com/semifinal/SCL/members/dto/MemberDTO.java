package com.semifinal.SCL.members.dto;

import com.semifinal.SCL.members.entity.Members;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@EqualsAndHashCode

public class MemberDTO {
	private String id;
	private String name;
	private String email;
	private String phone;
	
	public MemberDTO(Members member) {
		this.id=member.getId();
		this.email=member.getEmail();
		this.name=member.getName();
		this.phone=member.getPhone();
	}
	
}
