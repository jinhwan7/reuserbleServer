package com.reusable_server.reusableServer.member.application;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reusable_server.reusableServer.member.domain.Member;
import com.reusable_server.reusableServer.member.infrastructure.MemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member createMember(Member member) {
		// Perform additional validation if needed
		return memberRepository.save(member);
	}

	public Optional<Member> findOne(Long id) {
		return memberRepository.findById(id);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member updateMember(Long id, Member updatedMember) {
		return memberRepository.findById(id)
			.map(member -> {
				member.setName(updatedMember.getName());
				member.setEmail(updatedMember.getEmail());
				member.setPassword(updatedMember.getPassword());
				return memberRepository.save(member);
			})
			.orElseThrow(() -> new RuntimeException("Member not found"));
	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}
}