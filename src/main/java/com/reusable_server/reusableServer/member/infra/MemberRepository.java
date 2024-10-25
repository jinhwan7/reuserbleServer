package com.reusable_server.reusableServer.member.infra;


import com.reusable_server.reusableServer.member.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}