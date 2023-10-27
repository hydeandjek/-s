package com.semifinal.SCL.members.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 CREATE TABLE members
(
	ID varchar2(100) NOT NULL,
	PW varchar2(100) NOT NULL,
	name varchar2(100) NOT NULL,
	email varchar2(100) NOT NULL,
	phone varchar2(100) NOT NULL,
	PRIMARY KEY (ID)
);

 */

@Getter@Setter
@ToString@EqualsAndHashCode
@Builder
public class Members {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
}
