package com.reusable_server.reusableServer.member.infrastructure;

import com.reusable_server.reusableServer.member.domain.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 2, max = 50)
	private String name;

	@NotBlank
	@Size(min = 8, max = 30)
	private String password;

	@NotBlank
	@Email
	private String email;

	// 도메인 모델로 변환하는 메서드
	public Member toDomain() {
		return Member.builder()
			.name(this.name)
			.password(this.password)
			.email(this.email)
			.build();
	}

	// 도메인 모델로부터 엔티티를 생성하는 정적 메서드
	public static MemberEntity fromDomain(Member domain) {
		MemberEntity entity = new MemberEntity();
		entity.setName(domain.getName());
		entity.setPassword(domain.getPassword());
		entity.setEmail(domain.getEmail());
		return entity;
	}
}