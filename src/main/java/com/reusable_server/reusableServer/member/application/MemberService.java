// package com.reusable_server.reusableServer.member.application;
//
// import com.reusable_server.reusableServer.common.enums.ReturnCode;
// import com.reusable_server.reusableServer.common.exception.ReuserbleException;
//
// import java.util.List;
//
// import org.springframework.stereotype.Service;
//
// import com.reusable_server.reusableServer.member.application.dtos.MemberCreateParam;
// import com.reusable_server.reusableServer.member.application.dtos.MemberUpdateParam;
// import com.reusable_server.reusableServer.member.domain.Member;
// import com.reusable_server.reusableServer.member.infra.MemberRepository;
//
// import lombok.RequiredArgsConstructor;
//
// @Service
// @RequiredArgsConstructor
// public class MemberService {
// 	private final MemberRepository memberRepository;
//
// 	public Member createMember(MemberCreateParam memberCreateParam) {
//
// 		Member member = Member.builder()
// 			.name(memberCreateParam.getName())
// 			.email(memberCreateParam.getEmail())
// 			.password(memberCreateParam.getPassword())
// 			.build();
//
// 		return memberRepository.save(member);
// 	}
//
// 	public Member findOne(Long id) {
// 		return memberRepository.findById(id)
// 			.orElseThrow(() -> new ReuserbleException(ReturnCode.NOT_FOUND_ENTITY));
// 	}
//
// 	public List<Member> findAll() {
// 		return memberRepository.findAll();
// 	}
//
// 	public Member updateMember(Long id, MemberUpdateParam memberUpdateParam) {
// 		return memberRepository.findById(id)
// 			.map(member -> {
// 				member.setName(memberUpdateParam.getName());
// 				member.setEmail(memberUpdateParam.getEmail());
// 				member.setPassword(memberUpdateParam.getPassword());
// 				return memberRepository.save(member);
// 			})
// 			.orElseThrow(() -> new RuntimeException("Member not found"));
// 	}
//
// 	public void deleteMember(Long id) {
// 		memberRepository.deleteById(id);
// 	}
//
// }