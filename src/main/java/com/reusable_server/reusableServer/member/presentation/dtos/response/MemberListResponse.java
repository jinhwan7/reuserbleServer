package com.reusable_server.reusableServer.member.presentation.dtos.response;

import java.util.List;
import com.reusable_server.reusableServer.member.domain.Member;

public class MemberListResponse {
	private List<Member> members;

	public static MemberListResponse of(List<Member> memberList){
		MemberListResponse response = new MemberListResponse();
		response.members = memberList;
		return response;

	}
}
