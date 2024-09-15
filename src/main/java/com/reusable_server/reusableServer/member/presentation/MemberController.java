package com.reusable_server.reusableServer.member.presentation;

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
	public MemberCreateReponse signup(@Valid @RequestBody MemberCreateDTO memberCreateDTO) {
		Member createdMember = memberService.createMember(memberCreateDTO);
		return MemberCreateReponse.success(
			createdMember.getId(),
			createdMember.getName(),
			createdMember.getEmail()
		);
	}

	@GetMapping("/{id}")
	public MemberFindOneResponse findOne(@PathVariable Long id) {

		return memberService.findOne(id)
			.map((member) -> MemberFindOneResponse.success(member.getId(), member.getName(), member.getEmail()))
			.orElse(MemberFindOneResponse.error("not found"));
	}

	@GetMapping
	public MemberFindAllResponse findAll() {
		List<Member> members = memberService.findAll();
		return MemberFindAllResponse.success(members);
	}

	@PutMapping("/{id}")
	public MemberUpdateResponse updateMember(@PathVariable Long id,
		@Valid @RequestBody MemberUpdateDto memberUpdateDto) {
		Member updatedMember = memberService.updateMember(id, memberUpdateDto);
		return MemberUpdateResponse.success(updatedMember);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
		memberService.deleteMember(id);
		return ResponseEntity.noContent().build();
	}
}