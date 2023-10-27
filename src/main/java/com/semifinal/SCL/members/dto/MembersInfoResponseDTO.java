package com.semifinal.SCL.members.dto;

import java.util.ArrayList;
import java.util.List;

import com.semifinal.SCL.members.entity.Members;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter @ToString
@EqualsAndHashCode
@Builder @NoArgsConstructor
@AllArgsConstructor
public class MembersInfoResponseDTO {
	private String id;
	private String name;
	private String email;
	private String phone;
	
	
	public static MembersInfoResponseDTO toDTO(Members member) {
						
		return MembersInfoResponseDTO.builder()
						.id(member.getId())
						.name(member.getName())
						.email(member.getEmail())
						.phone(member.getPhone())
						.build();
	}
}
