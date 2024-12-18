package com.reusable_server.reusableServer.driver.infra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.reusable_server.reusableServer.common.entity.BaseEntity;
import com.reusable_server.reusableServer.common.enums.DriverStateCode;
import com.reusable_server.reusableServer.driver.domain.Driver;
import com.reusable_server.reusableServer.match.domain.Location;
import com.reusable_server.reusableServer.match.infra.MatchEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "driver")
@Getter
@Setter
@NoArgsConstructor
public class DriverEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Enumerated(EnumType.STRING)
	private DriverStateCode state;

	private String email;
	private String name;
	private String password;
	private Location location;

	@OneToMany(mappedBy = "driver")
	private List<MatchEntity> matchs = new ArrayList<>();

	@Column(name = "deleted_date_time")
	private LocalDateTime deletedDateTime;

	// 도메인 모델로 변환하는 메서드
	public Driver toDomain() {
		return Driver.builder()
			.id(this.id)
			.state(this.state)
			.email(this.email)
			.name(this.name)
			.password(this.password)
			.location(this.location)
			.build();
	}

	// 도메인 모델로부터 엔티티를 생성하는 정적 메서드
	public static DriverEntity fromDomain(Driver driver) {
		DriverEntity entity = new DriverEntity();
		entity.setId(driver.getId());
		entity.setState(driver.getState());
		entity.setEmail(driver.getEmail());
		entity.setName(driver.getName());
		entity.setPassword(driver.getPassword());
		return entity;
	}
}
