package com.reusable_server.reusableServer.member.presentation.dtos.response;

import com.reusable_server.reusableServer.member.domain.Member;

public class MemberUpdateResponse {
	private Long id;
	private String name;
	private String email;

	public static MemberUpdateResponse of(Member member) {
		MemberUpdateResponse response = new MemberUpdateResponse();
		response.id = member.getId();
		response.name = member.getName();
		response.email = member.getEmail();
		return response;
	}
}
