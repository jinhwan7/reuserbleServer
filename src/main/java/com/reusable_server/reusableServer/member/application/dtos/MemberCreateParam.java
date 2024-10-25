package com.reusable_server.reusableServer.member.application.dtos;
import com.reusable_server.reusableServer.member.presentation.dtos.request.MemberCreateRequest;

import lombok.Getter;

@Getter
public class MemberCreateParam {
	private String name;
	private String email;
	private String password;

	public static MemberCreateParam from(MemberCreateRequest dto) {
		MemberCreateParam memberCreateParam = new MemberCreateParam();

		memberCreateParam.password = dto.password();
		memberCreateParam.name = dto.name();
		memberCreateParam.email = dto.email();
		return memberCreateParam;

	}
}
