package com.reusable_server.reusableServer.member.presentation;

import com.reusable_server.reusableServer.common.dto.ApiResponse;
import com.reusable_server.reusableServer.common.enums.ReturnCode;
import com.reusable_server.reusableServer.member.presentation.dtos.MemberItemResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.reusable_server.reusableServer.member.application.MemberService;
import com.reusable_server.reusableServer.member.domain.Member;
import com.reusable_server.reusableServer.member.presentation.dtos.MemberCreateDTO;
import com.reusable_server.reusableServer.member.presentation.dtos.MemberUpdateDto;
import com.reusable_server.reusableServer.member.presentation.response.MemberCreateReponse;
import com.reusable_server.reusableServer.member.presentation.response.MemberFindAllResponse;
import com.reusable_server.reusableServer.member.presentation.response.MemberFindOneResponse;
import com.reusable_server.reusableServer.member.presentation.response.MemberUpdateResponse;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public ApiResponse<?> signup(@Valid @RequestBody MemberCreateDTO memberCreateDTO) {
		Member createdMember = memberService.createMember(memberCreateDTO);
		return ApiResponse.of(ReturnCode.SUCCESS);
		// TODO: DTO 변환 필요
//		return MemberCreateReponse.success(
//			createdMember.getId(),
//			createdMember.getName(),
//			createdMember.getEmail()
//		);
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
		// TODO: DTO로 변환 필요
		return ApiResponse.of(members);
	}

	@PutMapping("/{id}")
	public  ApiResponse<?> updateMember(@PathVariable Long id,
		@Valid @RequestBody MemberUpdateDto memberUpdateDto) {
		Member updatedMember = memberService.updateMember(id, memberUpdateDto);
		return ApiResponse.of(updatedMember);
	}

	@DeleteMapping("/{id}")
	public ApiResponse<?> deleteMember(@PathVariable Long id) {
		memberService.deleteMember(id);
		return ApiResponse.of(ReturnCode.SUCCESS);
	}
}