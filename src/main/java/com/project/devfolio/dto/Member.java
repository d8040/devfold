package com.project.devfolio.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int id; /* 회원번호 */
	private String regDate; /* 회원가입일 */
	private String updateDate; /* 회원정보 수정일 */
	private String loginId; 
	@JsonIgnore
	private String loginPw;

	private int authLevel; /* 회원분류(3: 일반, 5: 기업, 7: 관리자) */
	@JsonIgnore
	private String authKey; 
	private String name; /* 고객성명, 회사명 */
	private String nickname; /* 닉네임, 회사등록자성명 */
	private String birth;
	private String sex; /* 성별: 남, 여 */
	private String cellphoneNo; 
	private String email;
	private String remark; /* 일반: 자기소개, 기업: 기업소개 및 담당자 직무 */
	private String extra__thumbImg; /* 회원썸네일 */
	
	/*
	 * public String getAuthLevelName() { return MemberService.getAuthLevelName(this); }
	 * 
	 * public String getAuthLevelNameColor() { return MemberService.getAuthLevelNameColor(this); }
	 */
}
