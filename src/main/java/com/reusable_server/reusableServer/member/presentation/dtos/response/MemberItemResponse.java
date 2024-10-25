package com.reusable_server.reusableServer.member.presentation.dtos.response;

import com.reusable_server.reusableServer.member.domain.Member;

import lombok.Getter;

@Getter
public class MemberItemResponse {
	private Long id;
	private String name;
	private String email;

	public static MemberItemResponse of(Member member) {
		MemberItemResponse response = new MemberItemResponse();
		response.id = member.getId();
		response.name = member.getName();
		response.email = member.getEmail();
		return response;
	}
}
