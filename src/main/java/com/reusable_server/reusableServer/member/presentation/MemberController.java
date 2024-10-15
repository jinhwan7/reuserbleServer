package com.reusable_server.reusableServer.member.presentation;

import com.reusable_server.reusableServer.common.dto.ApiResponse;
import com.reusable_server.reusableServer.common.enums.ReturnCode;
import com.reusable_server.reusableServer.member.application.dtos.MemberCreateParam;
import com.reusable_server.reusableServer.member.application.dtos.MemberUpdateParam;
import com.reusable_server.reusableServer.member.presentation.dtos.response.MemberItemResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.reusable_server.reusableServer.member.application.MemberService;
import com.reusable_server.reusableServer.member.domain.Member;
import com.reusable_server.reusableServer.member.presentation.dtos.request.MemberCreateRequest;
import com.reusable_server.reusableServer.member.presentation.dtos.response.MemberListResponse;
import com.reusable_server.reusableServer.member.presentation.dtos.response.MemberSignupResponse;
import com.reusable_server.reusableServer.member.presentation.dtos.request.MemberUpdateRequest;
import com.reusable_server.reusableServer.member.presentation.dtos.response.MemberUpdateResponse;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public ApiResponse<?> signup(@Valid @RequestBody MemberCreateRequest memberCreateDTO) {


		MemberCreateParam memberCreateParam = MemberCreateParam.from(memberCreateDTO);

		Member createdMember = memberService.createMember(memberCreateParam);

		MemberSignupResponse memberSignupResponse = MemberSignupResponse.of(createdMember);
		return ApiResponse.of(memberSignupResponse);

	}

	@GetMapping("/{id}")
	public ApiResponse<?> findOne(@PathVariable Long id) {
		Member member = memberService.findOne(id);
		MemberItemResponse memberItemResponse = MemberItemResponse.of(member);
		return ApiResponse.of(memberItemResponse);
	}

	@GetMapping
	public ApiResponse<?> findAll() {
		List<Member> members = memberService.findAll();
		MemberListResponse memberListResponse = MemberListResponse.of(members);

		return ApiResponse.of(memberListResponse);
	}

	@PutMapping("/{id}")
	public ApiResponse<?> updateMember(@PathVariable Long id,
		@Valid @RequestBody MemberUpdateRequest memberUpdateRequest) {
		MemberUpdateParam memberUpdateParam = MemberUpdateParam.from(memberUpdateRequest);
		Member updatedMember = memberService.updateMember(id, memberUpdateParam);
		MemberUpdateResponse memberUpdateResponse = MemberUpdateResponse.of(updatedMember);

		return ApiResponse.of(memberUpdateResponse);
	}

	@DeleteMapping("/{id}")
	public ApiResponse<?> deleteMember(@PathVariable Long id) {
		memberService.deleteMember(id);
		return ApiResponse.of(ReturnCode.SUCCESS);
	}
}