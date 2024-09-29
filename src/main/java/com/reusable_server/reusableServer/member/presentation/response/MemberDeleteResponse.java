package com.reusable_server.reusableServer.member.presentation.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public record MemberDeleteResponse(Long id,
								   String name,
								   String email) {
}
