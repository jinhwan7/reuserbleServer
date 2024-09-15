package com.reusable_server.reusableServer.member.application;

import com.reusable_server.reusableServer.common.enums.ReturnCode;
import com.reusable_server.reusableServer.common.exception.ReuserbleException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reusable_server.reusableServer.member.domain.Member;
import com.reusable_server.reusableServer.member.infrastructure.MemberRepository;
import com.reusable_server.reusableServer.member.presentation.dtos.MemberCreateDTO;
import com.reusable_server.reusableServer.member.presentation.dtos.MemberUpdateDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	public Member createMember(MemberCreateDTO memberCreateDTO) {

		Member member = Member.builder()
			.name(memberCreateDTO.name())
			.email(memberCreateDTO.email())
			.password(memberCreateDTO.password())
			.build();

		return memberRepository.save(member);
	}

	public Member findOne(Long id) {
		return memberRepository.findById(id)
														.orElseThrow(() -> new ReuserbleException(ReturnCode.NOT_FOUND_ENTITY));
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public Member updateMember(Long id, MemberUpdateDto updatedMember) {
		return memberRepository.findById(id)
			.map(member -> {
				member.setName(updatedMember.name());
				member.setEmail(updatedMember.email());
				member.setPassword(updatedMember.password());
				return memberRepository.save(member);
			})
			.orElseThrow(() -> new RuntimeException("Member not found"));
	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}

}