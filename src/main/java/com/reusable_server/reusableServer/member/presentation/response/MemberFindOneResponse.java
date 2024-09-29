package com.reusable_server.reusableServer.member.presentation.response;

public record MemberFindOneResponse(Long id,
									String name,
									String email) {

	public static MemberFindOneResponse success(Long id, String name, String email) {
		return new MemberFindOneResponse(id, name, email);
	}

	// 오류 응답 생성 메서드
	public static MemberFindOneResponse error(String errorMessage) {
		return new MemberFindOneResponse(null, null, null, false, errorMessage);
	}
}
