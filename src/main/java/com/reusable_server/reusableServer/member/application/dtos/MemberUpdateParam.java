package com.reusable_server.reusableServer.member.application.dtos;

import com.reusable_server.reusableServer.member.presentation.dtos.request.MemberUpdateRequest;

import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class MemberUpdateParam {
	private String name;
	private String email;
	private String password;

	public static MemberUpdateParam from(@Valid MemberUpdateRequest dto) {
		MemberUpdateParam memberUpdateParam = new MemberUpdateParam();

		memberUpdateParam.password = dto.password();
		memberUpdateParam.name = dto.name();
		memberUpdateParam.email = dto.email();
		return memberUpdateParam;

	}
}
