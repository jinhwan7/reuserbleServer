package com.reusable_server.reusableServer.member.presentation.response;

import java.util.List;

import com.reusable_server.reusableServer.member.domain.Member;

public record MemberFindAllResponse(List<Member> members, String errorMessage) {

	public static MemberFindAllResponse success(List<Member> members) {
		return new MemberFindAllResponse(members, null);
	}

	// 오류 응답 생성 메서드
	public static MemberFindAllResponse error(String errorMessage) {
		return new MemberFindAllResponse(null, errorMessage);
	}
}
