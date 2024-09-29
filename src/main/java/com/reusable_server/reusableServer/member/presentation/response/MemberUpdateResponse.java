package com.reusable_server.reusableServer.member.presentation.response;

import com.reusable_server.reusableServer.member.domain.Member;

public record MemberUpdateResponse(Long id,
								   String name,
								   String email,
								   String errorMessage) {
	public static MemberUpdateResponse success(Member member) {
		return new MemberUpdateResponse(member.getId(), member.getName(), member.getEmail(), null);
	}

	// 오류 응답 생성 메서드
	public static MemberUpdateResponse error(String errorMessage) {
		return new MemberUpdateResponse(null, null, null, errorMessage);
	}
}
