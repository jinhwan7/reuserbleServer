package com.reusable_server.reusableServer.member.presentation;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.reusable_server.reusableServer.member.application.MemberService;
import com.reusable_server.reusableServer.member.domain.Member;

@RestController
@RequestMapping("/api/members")
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping
	public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
		return ResponseEntity.ok(memberService.createMember(member));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Member> findOne(@PathVariable Long id) {
		return memberService.findOne(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<Member>> findAll() {
		return ResponseEntity.ok(memberService.findAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Member> updateMember(@PathVariable Long id, @Valid @RequestBody Member member) {
		return ResponseEntity.ok(memberService.updateMember(id, member));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
		memberService.deleteMember(id);
		return ResponseEntity.noContent().build();
	}
}