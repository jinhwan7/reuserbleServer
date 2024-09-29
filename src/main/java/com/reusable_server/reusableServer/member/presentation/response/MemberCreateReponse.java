package com.reusable_server.reusableServer.member.presentation.response;

public record MemberCreateReponse(Long id,
								  String name,
								  String email) {

	public static MemberCreateReponse success(Long id, String name, String email) {
		return new MemberCreateReponse(id, name, email);
	}

	// 오류 응답 생성 메서드
	public static MemberCreateReponse error(String errorMessage) {
		return new MemberCreateReponse(null, null, null, false, Optional.of(errorMessage));
	}
}
